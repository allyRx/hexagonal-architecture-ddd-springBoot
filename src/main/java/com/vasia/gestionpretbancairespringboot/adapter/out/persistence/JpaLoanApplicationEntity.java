package com.vasia.gestionpretbancairespringboot.adapter.out.persistence;

import com.vasia.gestionpretbancairespringboot.domain.model.LoanApplication;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JpaLoanApplicationEntity {
    @Id
    private UUID id;
    private String clientId;
    private BigDecimal requestedAmount;
    private int termInMonths;
    @Enumerated(EnumType.STRING)
    private LoanApplication.LoanApplicationStatus status;
    private LocalDateTime applicationDate;
    private String rejectionReason;


    // Méthodes de conversion entre l'entité de domaine et l'entité JPA
    public static LoanApplication toDomain(JpaLoanApplicationEntity entity)
    {
        return new LoanApplication(
                entity.getId(),
                entity.getClientId(),
                entity.getRequestedAmount(),
                entity.getTermInMonths(),
                entity.getStatus(),
                entity.getApplicationDate()
        );
    }

    public static JpaLoanApplicationEntity fromDomain(LoanApplication domain) {
        return new JpaLoanApplicationEntity(
                domain.getId(),
                domain.getClientId(),
                domain.getRequestedAmount(),
                domain.getTermInMonths(),
                domain.getStatus(),
                domain.getApplicationDate(),
                domain.getRejectionReason()
        );
    }
}
