package com.hytech.logistics.main;

import com.hytech.logistics.enums.CustomerType;
import com.hytech.logistics.model.Customer;
import com.hytech.logistics.model.Shipment;
import com.hytech.logistics.service.LogisticsService;
import com.hytech.logistics.strategy.AirTransportStrategy;
import com.hytech.logistics.strategy.LandTransportStrategy;
import com.hytech.logistics.strategy.TransportStrategy;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== HY-TECH AKILLI LOJİSTİK MOTORU BAŞLATILIYOR ===\n");

        // 1. Müşterilerimizi oluşturuyoruz (Enum kullanıyoruz)
        Customer c1 = new Customer("C-001", "Ahmet Yılmaz", CustomerType.REGULAR);
        Customer c2 = new Customer("C-002", "Tech A.Ş.", CustomerType.CORPORATE);
        Customer c3 = new Customer("C-003", "Burak Alper", CustomerType.VIP);

        // 2. Kargolarımızı oluşturuyoruz
        Shipment s1 = new Shipment(c1, 10.5); // Ahmet'in 10.5 kg'lık kargosu
        Shipment s2 = new Shipment(c2, 50.0); // Tech A.Ş.'nin 50 kg'lık kargosu
        Shipment s3 = new Shipment(c3, 5.0);  // Burak'ın 5 kg'lık kargosu

        // 3. Taşıma stratejilerimizi (kuralları) hazırlıyoruz
        TransportStrategy air = new AirTransportStrategy();
        TransportStrategy land = new LandTransportStrategy();

        // 4. Servisimizi (Yönetici) ayağa kaldırıyoruz
        LogisticsService service = new LogisticsService();

        // 5. Siparişleri işliyoruz (Farklı taşıma tiplerini içeri yolluyoruz)
        service.processShipment(s1, land); // Ahmet'in kargosu Karayolu ile gitsin (İndirim yok)
        service.processShipment(s2, land); // Tech A.Ş. Karayolu ile gitsin (%15 kurumsal indirim)
        service.processShipment(s3, air);  // VIP müşteri Burak'ın kargosu Havayolu ile gitsin (%30 VIP indirim)

        System.out.println("Aktif işlenen toplam kargo sayısı: " + service.getTotalActiveShipments());
    }
}