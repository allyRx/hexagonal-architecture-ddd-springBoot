package com.vasia.gestionpretbancairespringboot.adapter.in.web;


import com.vasia.gestionpretbancairespringboot.adapter.in.dto.LoanApplicationRequest;
import com.vasia.gestionpretbancairespringboot.adapter.in.dto.LoanApplicationResponse;
import com.vasia.gestionpretbancairespringboot.domain.model.LoanApplication;
import com.vasia.gestionpretbancairespringboot.domain.port.in.LoanApplicationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanApplicationController {

    private final LoanApplicationUseCase loanApplicationUseCase;

    @PostMapping
    public ResponseEntity<LoanApplicationResponse> submitLoanApplication(@RequestBody LoanApplicationRequest request) {
        LoanApplication application = loanApplicationUseCase.submitApplication(
                        request.getClientId(),
                        request.getRequestedAmount(),
                        request.getTermInMonths()
                );
        return new ResponseEntity<>(toResponse(application), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LoanApplicationResponse> getLoanApplication(@PathVariable UUID id) {
        return loanApplicationUseCase.getApplicationById(id)
                .map(this::toResponse)
                .map(response -> new ResponseEntity<>(response,
                        HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}/process")
    public ResponseEntity<LoanApplicationResponse> processLoanApplication(@PathVariable UUID id) {
        try {
            LoanApplication processedApplication =
                    loanApplicationUseCase.processApplication(id);
            return new ResponseEntity<>(toResponse(processedApplication),
                    HttpStatus.OK);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private LoanApplicationResponse toResponse(LoanApplication application)
    {
        return new LoanApplicationResponse(
                application.getId().toString(),
                application.getClientId(),
                application.getRequestedAmount(),
                application.getTermInMonths(),
                application.getStatus().name(),
                application.getApplicationDate(),
                application.getRejectionReason()
        );
    }
}
