package com.hytech.logistics.strategy;

import com.hytech.logistics.model.Shipment;

public class AirTransportStrategy implements TransportStrategy {
    
    private static final double BASE_PRICE_PER_KG = 50.0; 

    @Override
    public double calculateCost(Shipment shipment) {
        double baseCost = shipment.getWeightInKg() * BASE_PRICE_PER_KG;
        
        double discountMultiplier = shipment.getSender().getCustomerType().getDiscountMultiplier();
        
        return baseCost * discountMultiplier;
    }
}