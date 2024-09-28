package com.currencyexchange.discountBusiness;

import org.springframework.stereotype.Component;

@Component
public class DiscountManager {

    public DiscountStrategy getDiscountStrategy(String userType, boolean isGrocery, int customerTenure) {
        if (isGrocery) {
            return new NoDiscount();
        }

        return switch (userType.toLowerCase()) {
            case "employee" -> new EmployeeDiscount();
            case "affiliate" -> new AffiliateDiscount();
            default -> new LoyaltyDiscount(customerTenure);
        };
    }
}
