package com.currencyexchange.service;

import com.currencyexchange.discountBusiness.DiscountManager;
import com.currencyexchange.discountBusiness.DiscountStrategy;
import com.currencyexchange.discountBusiness.FlatDiscount;
import com.currencyexchange.dto.BillDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements  CurrencyService {

    private final DiscountManager discountManager;
    @Override
    public double calculateDiscountedAmount(BillDetails billDetails) {
        DiscountStrategy flatDiscount = new FlatDiscount();
        double flatDiscountAmount = flatDiscount.applyDiscount(billDetails.getTotalAmount());
        DiscountStrategy discountStrategy = discountManager.getDiscountStrategy(billDetails.getUserType(), billDetails.isGrocery(), billDetails.getCustomerTenure());
        double percentageDiscountAmount = discountStrategy.applyDiscount(billDetails.getTotalAmount());
        return billDetails.getTotalAmount() - flatDiscountAmount - percentageDiscountAmount;
    }
}
