package com.hytech.logistics.service;

import com.hytech.logistics.enums.CargoStatus;
import com.hytech.logistics.model.Shipment;
import com.hytech.logistics.strategy.TransportStrategy;

import java.util.ArrayList;
import java.util.List;

public class LogisticsService {
    
    /**
     * MÜLAKAT SORUSU: Neden "ArrayList<Shipment> shipments = new ArrayList<>();" yerine 
     * "List<Shipment> shipments = new ArrayList<>();" yazıyoruz?
     * CEVAP: Polimorfizm! Sol tarafta her zaman Interface (List) kullanmalıyız. 
     * Yarın bir gün veri yapımızı LinkedList olarak değiştirmek istersek, sadece sağ tarafı 
     * (new LinkedList<>()) değiştirmemiz yeterli olur. Sistemin geri kalanı etkilenmez.
     */
    private List<Shipment> activeShipments;

    public LogisticsService() {
        this.activeShipments = new ArrayList<>();
    }

    /**
     * MÜLAKAT SORUSU: Bu metoda parametre olarak neden 'AirTransportStrategy' yerine 
     * 'TransportStrategy' (Interface) verdik?
     * CEVAP: Gevşek bağımlılık (Loose Coupling) ve Polimorfizm için. Bu sayede bu metot hem Hava, 
     * hem Kara, hem de gelecekte eklenecek Deniz taşımacılığı için tek başına çalışabilir. 
     * Kod tekrarından kurtuluruz.
     */
    public void processShipment(Shipment shipment, TransportStrategy strategy) {
        // Kargoyu listemize ekliyoruz
        activeShipments.add(shipment);
        
        // Kargonun durumunu 'Yolda' olarak güncelliyoruz
        shipment.setStatus(CargoStatus.IN_TRANSIT);

        // Stratejiye göre fiyatı hesaplatıyoruz (Polimorfizm burada devreye giriyor)
        double cost = strategy.calculateCost(shipment);

        // Konsola şık bir lojistik fişi basıyoruz
        System.out.println("--------------------------------------------------");
        System.out.println("Kargo Takip No : " + shipment.getTrackingNumber());
        System.out.println("Müşteri        : " + shipment.getSender().getFullName() + " (" + shipment.getSender().getCustomerType() + ")");
        System.out.println("Ağırlık        : " + shipment.getWeightInKg() + " KG");
        System.out.println("Durum          : " + shipment.getStatus());
        System.out.println("Hesaplanan Tutar: " + String.format("%.2f", cost) + " TL");
        System.out.println("--------------------------------------------------\n");
    }

    // Sisteme kayıtlı toplam kargo sayısını döndüren basit bir metot
    public int getTotalActiveShipments() {
        return activeShipments.size();
    }
}