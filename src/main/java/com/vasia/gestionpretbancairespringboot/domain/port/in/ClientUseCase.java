package com.vasia.gestionpretbancairespringboot.domain.port.in;

import com.vasia.gestionpretbancairespringboot.domain.model.Client;

import java.math.BigDecimal;
import java.util.Optional;


public interface ClientUseCase {
    Client Saveclient(String name , String email , BigDecimal monthlyIncome,int creditScore);
   Optional<Client> getClientById(String id);

}
