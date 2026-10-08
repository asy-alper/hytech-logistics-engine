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
    
        Customer c1 = new Customer("C-001", "Ahmet Yılmaz", CustomerType.REGULAR);
        Customer c2 = new Customer("C-002", "Tech A.Ş.", CustomerType.CORPORATE);
        Customer c3 = new Customer("C-003", "Burak Alper", CustomerType.VIP);
  
        Shipment s1 = new Shipment(c1, 10.5); 
        Shipment s2 = new Shipment(c2, 50.0); 
        Shipment s3 = new Shipment(c3, 5.0); 

        TransportStrategy air = new AirTransportStrategy();
        TransportStrategy land = new LandTransportStrategy();

        LogisticsService service = new LogisticsService();

        service.processShipment(s1, land); 
        service.processShipment(s2, land); 
        service.processShipment(s3, air); 

        System.out.println("Aktif işlenen toplam kargo sayısı: " + service.getTotalActiveShipments());
    }
}