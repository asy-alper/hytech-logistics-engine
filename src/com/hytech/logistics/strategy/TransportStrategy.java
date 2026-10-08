package com.hytech.logistics.strategy;

import com.hytech.logistics.model.Shipment;

public interface TransportStrategy {
    

    default double calculateCost(Shipment shipment) {

        System.out.println("LOG: " + getClass().getSimpleName() + " default calculation is using.");

        double defaultBaseCost = shipment.getWeightInKg() * 10.0;
        double discountMultiplier = shipment.getSender().getCustomerType().getDiscountMultiplier();
        
        return defaultBaseCost * discountMultiplier;
    }
}