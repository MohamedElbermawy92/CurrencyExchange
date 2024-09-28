package com.currencyexchange.exchangeIntegration;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class CurrencyExchangeResponse {

    private Map<String, Double> rates;
    private String base;
    private String date;

}
