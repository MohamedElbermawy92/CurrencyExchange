package com.currencyexchange.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class BillDetails {

    private List<Item> items;

    @NotNull
    private double totalAmount;

    @NotNull
    private String userType;

    @NotNull
    private String originalCurrency;

    @NotNull
    private String targetCurrency;

    private int customerTenure;
    private boolean isGrocery = false;

}
