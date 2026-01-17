package com.vasia.gestionpretbancairespringboot.domain.service;


import com.vasia.gestionpretbancairespringboot.domain.model.Client;
import com.vasia.gestionpretbancairespringboot.domain.model.LoanApplication;
import com.vasia.gestionpretbancairespringboot.domain.port.in.ClientUseCase;
import com.vasia.gestionpretbancairespringboot.domain.port.in.LoanApplicationUseCase;
import com.vasia.gestionpretbancairespringboot.domain.port.out.CreditCheckPort;
import com.vasia.gestionpretbancairespringboot.domain.port.out.LoanApplicationRepositoryPort;
import com.vasia.gestionpretbancairespringboot.domain.port.out.NotificationPort;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;


@AllArgsConstructor
public class LoanApplicationService implements LoanApplicationUseCase, ClientUseCase {

    private final LoanApplicationRepositoryPort loanApplicationRepositoryPort;
    private final CreditCheckPort creditCheckPort;
    private final NotificationPort notificationPort;


    @Override
    public LoanApplication submitApplication(String clientId, BigDecimal requestedAmount, int termInMonths ){
        // // Ici, on pourrait récupérer le client via un ClientRepositoryPort si nécessaire
        // Optional<User> client = userRepositoryPort.findById(clientId);
        // if(client.isEmpty()){
        //     throw new RuntimeException("User not Found");
        // }

        LoanApplication application = new LoanApplication(clientId,requestedAmount,termInMonths);

        if(requestedAmount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Requested amount must be positive");
        }

        return loanApplicationRepositoryPort.save(application);
    }

    @Override
    public Optional<LoanApplication> getApplicationById(UUID id) {
        return loanApplicationRepositoryPort.findById(id);
    }


    //processus de demande de pret!!
    @Override
    public LoanApplication processApplication(UUID applicationId) {

        LoanApplication application = loanApplicationRepositoryPort.findById(applicationId).orElseThrow(() -> new IllegalArgumentException("Loan application not found."));

        if (application.getStatus() != LoanApplication.LoanApplicationStatus.PENDING) {
            throw new IllegalStateException("Application is not in PENDING status.");
        }

     // Effectuer la vérification de crédit via le port
        boolean isCreditApproved = creditCheckPort.checkCredit(application.getClientId());
        if (isCreditApproved && application.isEligibleForApproval()) {
            application.approve();
            notificationPort.sendNotification(application.getClientId(),
                    "Your loan application has been approved!");
        } else {
            String reason = isCreditApproved ? "Loan amount exceeds limit."
                    : "Credit check failed.";
            application.rejected(reason);
            notificationPort.sendNotification(application.getClientId(),
                    "Your loan application has been rejected: " + reason);
        }
        return loanApplicationRepositoryPort.save(application);
    }

    @Override
    public Client Saveclient(String name, String email, BigDecimal monthlyIncome, int creditScore) {
        return null;
    }

    @Override
    public Optional<Client> getClientById(String id) {
        return Optional.empty();
    }
}
