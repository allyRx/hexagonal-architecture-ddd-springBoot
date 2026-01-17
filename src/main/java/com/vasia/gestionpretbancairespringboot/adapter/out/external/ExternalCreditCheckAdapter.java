package com.vasia.gestionpretbancairespringboot.adapter.out.external;

import com.vasia.gestionpretbancairespringboot.domain.port.out.CreditCheckPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExternalCreditCheckAdapter implements CreditCheckPort {

    @Override
    public boolean checkCredit(String clientId) {
        // TODO: Implémenter l'appel à un service de vérification de crédit externe
        // Pour maintenant, retourner true par défaut
        return true;
    }
}
