package com.vasia.gestionpretbancairespringboot.application.config;

import com.vasia.gestionpretbancairespringboot.domain.port.out.CreditCheckPort;
import com.vasia.gestionpretbancairespringboot.domain.port.out.LoanApplicationRepositoryPort;
import com.vasia.gestionpretbancairespringboot.domain.port.out.NotificationPort;
import com.vasia.gestionpretbancairespringboot.domain.service.LoanApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public LoanApplicationService loanApplicationService(
            LoanApplicationRepositoryPort loanApplicationRepositoryPort,
            CreditCheckPort creditCheckPort,
            NotificationPort notificationPort
    ){
        return new LoanApplicationService(loanApplicationRepositoryPort , creditCheckPort, notificationPort);
    }

}
