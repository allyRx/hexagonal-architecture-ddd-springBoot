package com.vasia.gestionpretbancairespringboot.domain.port.out;

public interface CreditCheckPort {
    boolean checkCredit(String clientId);
}
