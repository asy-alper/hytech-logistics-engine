package com.hytech.logistics.service;

import com.hytech.logistics.enums.CargoStatus;
import com.hytech.logistics.model.Shipment;
import com.hytech.logistics.strategy.TransportStrategy;

import java.util.ArrayList;
import java.util.List;

public class LogisticsService {
    
    private List<Shipment> activeShipments;

    public LogisticsService() {
        this.activeShipments = new ArrayList<>();
    }

    public void processShipment(Shipment shipment, TransportStrategy strategy) {

        activeShipments.add(shipment);
        
        shipment.setStatus(CargoStatus.IN_TRANSIT);

        double cost = strategy.calculateCost(shipment);

        System.out.println("--------------------------------------------------");
        System.out.println("Kargo Takip No : " + shipment.getTrackingNumber());
        System.out.println("Müşteri        : " + shipment.getSender().getFullName() + " (" + shipment.getSender().getCustomerType() + ")");
        System.out.println("Ağırlık        : " + shipment.getWeightInKg() + " KG");
        System.out.println("Durum          : " + shipment.getStatus());
        System.out.println("Hesaplanan Tutar: " + String.format("%.2f", cost) + " TL");
        System.out.println("--------------------------------------------------\n");
    }

    public int getTotalActiveShipments() {
        return activeShipments.size();
    }
}