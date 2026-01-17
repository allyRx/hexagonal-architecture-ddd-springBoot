package com.vasia.gestionpretbancairespringboot.domain.port.out;

import com.vasia.gestionpretbancairespringboot.domain.model.LoanApplication;

import java.util.Optional;
import java.util.UUID;

public interface LoanApplicationRepositoryPort {
    LoanApplication save(LoanApplication loanApplication);
    Optional<LoanApplication> findById(UUID id);
    LoanApplication deleteById(UUID id);
}
