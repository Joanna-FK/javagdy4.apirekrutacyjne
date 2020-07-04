package com.sda.javagdy4_apirekrutacyjne;

import lombok.Data;

import java.util.List;
//POJO- plain old java object:
//- pusty konstruktor;
//-prywatne pola;
//-gettery, settery
//
@Data

public class ExchangeRates {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;
}
