package com.hytech.logistics.model;

import com.hytech.logistics.enums.CargoStatus;
import java.util.UUID;

/**
 * Shipment (Kargo/Gönderi) sınıfı, Customer (Müşteri) nesnesini içinde barındırır.
 * MÜLAKAT SORUSU: Sınıflar arası ilişkilerde Composition/Aggregation (Has-A ilişkisi) nedir?
 * CEVAP: Bir sınıfın, başka bir sınıfın nesnesini özellik (field) olarak barındırmasıdır.
 * Örneğin "Shipment HAS A Customer" (Gönderinin bir müşterisi vardır). 
 * Kalıtım (IS-A) yerine Composition kullanmak kodun esnekliğini artırır.
 */
public class Shipment {
    private final String trackingNumber; // final yaptık, takip numarası sonradan değişemez.
    private Customer sender;
    private double weightInKg;
    private CargoStatus status;

    public Shipment(Customer sender, double weightInKg) {
        // Benzersiz takip numarası oluşturuyoruz
        this.trackingNumber = "TRK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.sender = sender;
        setWeightInKg(weightInKg);
        this.status = CargoStatus.PENDING_APPROVAL; // Varsayılan durum
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