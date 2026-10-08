package com.hytech.logistics.strategy;

import com.hytech.logistics.model.Shipment;

/**
 * MÜLAKAT SORUSU: @Override anotasyonu ne işe yarar? Yazmazsak ne olur?
 * CEVAP: Üst sınıftan veya interface'den gelen metodu ezdiğimizi (kendi mantığımızla doldurduğumuzu) 
 * derleyiciye bildirir. Yazmazsak kod yine çalışır, ancak metot ismini yanlış yazarsak (örn: calculateCostt) 
 * derleyici uyarı vermez, yepyeni bir metot sanır ve Interface kuralını çiğnediğimiz için program patlar.
 */
public class AirTransportStrategy implements TransportStrategy {
    
    // static final: Bellekte tek yer kaplayan, değiştirilemez sabit (Constant) değer.
    private static final double BASE_PRICE_PER_KG = 50.0; 

    @Override
    public double calculateCost(Shipment shipment) {
        // Temel taşıma ücreti
        double baseCost = shipment.getWeightInKg() * BASE_PRICE_PER_KG;
        
        // Müşterinin tipine (VIP, CORPORATE) göre Enum içindeki indirim çarpanını alıyoruz
        double discountMultiplier = shipment.getSender().getCustomerType().getDiscountMultiplier();
        
        return baseCost * discountMultiplier;
    }
}