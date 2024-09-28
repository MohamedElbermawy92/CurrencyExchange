package com.currencyexchange.controller;

import com.currencyexchange.dto.BillDetails;
import com.currencyexchange.exchangeIntegration.CurrencyConversionService;
import com.currencyexchange.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CurrencyController {

    private final CurrencyService currencyService;
    private final CurrencyConversionService currencyConversionService;

    @Operation(summary = "currency exchange")
    @PostMapping("/calculate")
    public ResponseEntity<Double> calculate(@Valid @RequestBody BillDetails billDetails){

        double discountedAmount = currencyService.calculateDiscountedAmount(billDetails);
        double payableAmount = currencyConversionService.convertCurrency(discountedAmount,
                billDetails.getOriginalCurrency(),
                billDetails.getTargetCurrency());
        return ResponseEntity.ok(payableAmount);
    }
}
