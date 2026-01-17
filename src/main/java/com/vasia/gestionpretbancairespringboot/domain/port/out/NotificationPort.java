package com.vasia.gestionpretbancairespringboot.domain.port.out;

public interface NotificationPort {
    void sendNotification(String recipientId, String message);
}
