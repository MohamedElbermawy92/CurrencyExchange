package com.currencyexchange.discountBusiness;

public class FlatDiscount implements DiscountStrategy{

    @Override
    public double applyDiscount(double totalAmount) {
        if(totalAmount%100 ==0)
            return (int) (totalAmount / 100) * 5;
        return 0;
    }
}
