package com.vasia.gestionpretbancairespringboot.adapter.in.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class LoanApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String clientId;
    private BigDecimal requestedAmount;
    private int termInMonths;
}
