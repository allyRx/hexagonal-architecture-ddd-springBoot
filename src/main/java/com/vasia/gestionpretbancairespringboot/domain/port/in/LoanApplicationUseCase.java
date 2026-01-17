package com.vasia.gestionpretbancairespringboot.domain.port.in;


import com.vasia.gestionpretbancairespringboot.domain.model.LoanApplication;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public interface LoanApplicationUseCase {
    LoanApplication submitApplication(String clientId, BigDecimal requestedAmount, int termInMonths);

    Optional<LoanApplication> getApplicationById(UUID id);

    LoanApplication processApplication(UUID applicationId);
}
