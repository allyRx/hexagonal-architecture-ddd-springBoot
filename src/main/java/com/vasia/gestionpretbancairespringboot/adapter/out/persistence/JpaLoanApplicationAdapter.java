package com.vasia.gestionpretbancairespringboot.adapter.out.persistence;

import com.vasia.gestionpretbancairespringboot.adapter.out.repository.JpaLoanApplicationRepository;
import com.vasia.gestionpretbancairespringboot.domain.model.LoanApplication;
import com.vasia.gestionpretbancairespringboot.domain.port.out.LoanApplicationRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JpaLoanApplicationAdapter implements LoanApplicationRepositoryPort {
    private final JpaLoanApplicationRepository jpaLoanApplicationRepository;

    @Override
    public LoanApplication save(LoanApplication loanApplication) {
        JpaLoanApplicationEntity entity = JpaLoanApplicationEntity.fromDomain(loanApplication);

        JpaLoanApplicationEntity savedEntity = jpaLoanApplicationRepository.save(entity);

        return JpaLoanApplicationEntity.toDomain(savedEntity);
    }

    @Override
    public Optional<LoanApplication> findById(UUID id) {
        return jpaLoanApplicationRepository.findById(id)
                .map(JpaLoanApplicationEntity::toDomain);
    }

    @Override
    public LoanApplication deleteById(UUID id) {
        return null;
    }
}
