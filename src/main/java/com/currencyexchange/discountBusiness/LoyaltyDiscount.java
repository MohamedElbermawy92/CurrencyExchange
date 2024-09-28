package com.currencyexchange.discountBusiness;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoyaltyDiscount implements DiscountStrategy{

    private int customerTenure;
    @Override
    public double applyDiscount(double totalAmount) {
        if (customerTenure > 2) {
            return totalAmount * 0.05;
        }
        return 0;
    }
}
