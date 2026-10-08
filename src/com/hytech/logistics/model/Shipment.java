package com.hytech.logistics.model;

import com.hytech.logistics.enums.CargoStatus;
import java.util.UUID;


public class Shipment {
    private final String trackingNumber; 
    private Customer sender;
    private double weightInKg;
    private CargoStatus status;

    public Shipment(Customer sender, double weightInKg) {

        this.trackingNumber = "TRK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.sender = sender;
        setWeightInKg(weightInKg);
        this.status = CargoStatus.PENDING_APPROVAL; 
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public Customer getSender() {
        return sender;
    }

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        if (weightInKg <= 0) {
            throw new IllegalArgumentException("This value can't be 0 or lower.");
        }
        this.weightInKg = weightInKg;
    }

    public CargoStatus getStatus() {
        return status;
    }

    public void setStatus(CargoStatus status) {
        this.status = status;
    }
}