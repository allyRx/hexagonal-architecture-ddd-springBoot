package com.vasia.gestionpretbancairespringboot.domain.model;

import lombok.Getter;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.UUID;

/***
 * Le model est de porter le comportement métier, et  les données.
 * **/
@Getter
public class LoanApplication {

    private UUID id;
    private String clientId;
    private BigDecimal requestedAmount;
    private  int termInMonths;
    private LoanApplicationStatus status;
    private LocalDateTime applicationDate;
    private String rejectionReason;


    //constructeur
    public LoanApplication(UUID id, String clientId, BigDecimal
            requestedAmount, int termInMonths, LoanApplicationStatus status, LocalDateTime
                                   applicationDate) {
        this.id = id;
        this.clientId = clientId;
        this.requestedAmount = requestedAmount;
        this.termInMonths = termInMonths;
        this.status = status;
        this.applicationDate = applicationDate;

    }

    // Constructeur pour une nouvelle application (sans ID initial)
    public LoanApplication(String clientId, BigDecimal requestedAmount, int
            termInMonths, String rejectionReason) {
        this.rejectionReason = rejectionReason;
        this.id = UUID.randomUUID();
        this.clientId = clientId;
        this.requestedAmount = requestedAmount;
        this.termInMonths = termInMonths;
        this.status = LoanApplicationStatus.PENDING;
        this.applicationDate = LocalDateTime.now();
    }

    public LoanApplication(String clientId, BigDecimal requestedAmount, int termInMonths) {
        this.id = UUID.randomUUID();
        this.clientId = clientId;
        this.requestedAmount = requestedAmount;
        this.termInMonths = termInMonths;
        this.status = LoanApplicationStatus.PENDING;
        this.applicationDate = LocalDateTime.now();
    }

    //enum pour le status de pret
    public enum LoanApplicationStatus{
        PENDING, APPROVED, REJECTED
    }


    // Méthodes de comportement du domaine
    public void approve(){
        if(this.status != LoanApplicationStatus.PENDING){
            throw new IllegalStateException("Cannot approve a loan application that is not PENDING.");
        }
        this.status = LoanApplicationStatus.APPROVED;
    }

    public void rejected(String reason){
        if(this.status != LoanApplicationStatus.PENDING) {
            throw new IllegalStateException("Cannot reject a loan application that is not PENDING.");
        }
        this.status = LoanApplicationStatus.REJECTED;
        this.rejectionReason = reason;
    }

    public boolean isEligibleForApproval() {
        // Exemple de règle métier : le montant demandé ne doit pas dépasser 100 000
        return this.requestedAmount.compareTo(new BigDecimal("100000")) <= 0;
    }

}



