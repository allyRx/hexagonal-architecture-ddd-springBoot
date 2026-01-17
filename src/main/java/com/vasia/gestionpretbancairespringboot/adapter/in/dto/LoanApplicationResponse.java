package com.vasia.gestionpretbancairespringboot.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LoanApplicationResponse {
    private String id;
    private String clientId;
    private BigDecimal requestedAmount;
    private int termInMonths;
    private String status;
    private LocalDateTime applicationDate;
    private String rejectionReason;
}
