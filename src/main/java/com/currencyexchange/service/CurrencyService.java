package com.currencyexchange.service;

import com.currencyexchange.dto.BillDetails;

public interface CurrencyService {

    double calculateDiscountedAmount(BillDetails billDetails);
}
