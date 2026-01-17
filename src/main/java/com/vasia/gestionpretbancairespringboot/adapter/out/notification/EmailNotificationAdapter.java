package com.vasia.gestionpretbancairespringboot.adapter.out.notification;

import com.vasia.gestionpretbancairespringboot.domain.port.out.NotificationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailNotificationAdapter implements NotificationPort {

    @Override
    public void sendNotification(String recipientId, String message) {
        // TODO: Implémenter l'envoi d'email via un service d'email (exemple: JavaMailSender)
        // Pour maintenant, simplement logger le message
        System.out.println("Email envoyé à " + recipientId + ": " + message);
    }
}
