package com.vasia.gestionpretbancairespringboot.domain.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Client {
    private final String id;
    private final String name;
    private final String email;
    private final BigDecimal monthlyIncome;
    private final int creditScore;


    public Client(String id, String name, String email, BigDecimal
            monthlyIncome, int creditScore) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.monthlyIncome = monthlyIncome;
        this.creditScore = creditScore;
    }

    public boolean hasGoodCreditScore(){
        return this.creditScore >= 650;
    }

}
