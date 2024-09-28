package com.currencyexchange;

import com.currencyexchange.controller.CurrencyController;
import com.currencyexchange.dto.BillDetails;
import com.currencyexchange.dto.Item;
import com.currencyexchange.exchangeIntegration.CurrencyConversionService;
import com.currencyexchange.service.CurrencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class DiscountServiceTest {

    @InjectMocks
    private CurrencyController currencyController;

    @Mock
    private CurrencyService currencyService;

    @Mock
    private CurrencyConversionService currencyConversionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculate() {

        BillDetails billDetails = new BillDetails();
        billDetails.setOriginalCurrency("USD");
        billDetails.setTargetCurrency("EUR");
        billDetails.setItems(Collections.singletonList(new Item(1,"item1")));
        billDetails.setGrocery(false);
        billDetails.setCustomerTenure(3);
        billDetails.setUserType("employee");
        billDetails.setTotalAmount(600);

        double discountedAmount = 95.0;
        double expectedPayableAmount = 100.0;

        when(currencyService.calculateDiscountedAmount(billDetails)).thenReturn(discountedAmount);
        when(currencyConversionService.convertCurrency(discountedAmount, "USD", "EUR"))
                .thenReturn(expectedPayableAmount);

        ResponseEntity<Double> responseEntity = currencyController.calculate(billDetails);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedPayableAmount, responseEntity.getBody());
    }

}
