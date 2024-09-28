package com.currencyexchange.discountBusiness;


public class EmployeeDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.30;
    }
}
