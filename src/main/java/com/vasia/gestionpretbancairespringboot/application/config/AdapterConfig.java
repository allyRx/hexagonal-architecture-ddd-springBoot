package com.vasia.gestionpretbancairespringboot.application.config;

import com.vasia.gestionpretbancairespringboot.adapter.out.external.ExternalCreditCheckAdapter;
import com.vasia.gestionpretbancairespringboot.adapter.out.notification.EmailNotificationAdapter;
import com.vasia.gestionpretbancairespringboot.adapter.out.persistence.JpaLoanApplicationAdapter;
import com.vasia.gestionpretbancairespringboot.adapter.out.persistence.JpaUserAdapter;
import com.vasia.gestionpretbancairespringboot.domain.port.out.CreditCheckPort;
import com.vasia.gestionpretbancairespringboot.domain.port.out.LoanApplicationRepositoryPort;
import com.vasia.gestionpretbancairespringboot.domain.port.out.NotificationPort;
import com.vasia.gestionpretbancairespringboot.domain.port.out.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {
    // Expose les adaptateurs comme des ports secondaires
    @Bean
    public LoanApplicationRepositoryPort loanApplicationRepositoryPort(JpaLoanApplicationAdapter adapter) {
        return adapter;
    }
    @Bean
    public CreditCheckPort creditCheckPort(ExternalCreditCheckAdapter adapter) {
        return adapter;
    }
    @Bean
    public NotificationPort notificationPort(EmailNotificationAdapter
                                                     adapter) {
        return adapter;
    }
    @Bean
    public UserRepositoryPort userRepositoryPort(JpaUserAdapter adapter) {
        return adapter;
    }
}
