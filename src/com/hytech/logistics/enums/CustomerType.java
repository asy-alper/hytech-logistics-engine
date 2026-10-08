package com.hytech.logistics.enums;


public enum CustomerType {
    
    REGULAR(1.0),     
    CORPORATE(0.85),   
    VIP(0.70);        

    private final double discountMultiplier;


    CustomerType(double discountMultiplier) {
        this.discountMultiplier = discountMultiplier;
    }

    public double getDiscountMultiplier() {
        return discountMultiplier;
    }
}