package com.currencyexchange.exchangeIntegration;

import com.currencyexchange.exceptionHandle.CurrencyConversionException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CurrencyConversionService {

    private final RestTemplate restTemplate;

    @Value("${currency.api.key}")
    private String apiKey;

    private static final String API_URL = "https://open.er-api.com/v6/latest/{base_currency}?apikey={apiKey}";

    @Cacheable(value = "exchangeRates", key = "#fromCurrency")
    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        String url = API_URL.replace("{base_currency}", fromCurrency)
                .replace("{apiKey}", apiKey);

        ResponseEntity<CurrencyExchangeResponse> responseEntity =
                restTemplate.getForEntity(url, CurrencyExchangeResponse.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            CurrencyExchangeResponse response = responseEntity.getBody();
            double exchangeRate = Objects.requireNonNull(response).getRates().get(toCurrency);
            return amount * exchangeRate;
        } else {
            throw new CurrencyConversionException("Error fetching exchange rate");
        }
    }
}
