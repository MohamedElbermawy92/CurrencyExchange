package com.currencyexchange.discountBusiness;

public class AffiliateDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.10;
    }
}
