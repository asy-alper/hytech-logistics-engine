package com.hytech.logistics.enums;

/**
 * MÜLAKAT SORUSU: Enum (Enumeration) nedir ve kurumsal projelerde neden String yerine Enum tercih edilir?
 * BEKLENEN CEVAP: Tip güvenliğini (Type Safety) sağlamak, bellek optimizasyonu yapmak ve kısıtlı değer kümelerini 
 * (VIP, REGULAR gibi) standartlaştırmak için kullanılır. String kullanırsak yazım hataları (örneğin "Vip" yerine "VIp") 
 * çalışma zamanı (Runtime) hatalarına yol açar. Enum'lar derleme zamanında (Compile-time) bu hataları engeller.
 */
public enum CustomerType {
    
    REGULAR(1.0),      // Çarpan 1.0 (İndirim yok)
    CORPORATE(0.85),   // Kurumsal müşteriye %15 indirim (Fiyat * 0.85)
    VIP(0.70);         // VIP müşteriye %30 indirim (Fiyat * 0.70)

    // final: Değişkenin değeri constructor'da bir kez atanır ve sonradan kimse değiştiremez (Immutability).
    private final double discountMultiplier;

    // MÜLAKAT SORUSU: Enum'ların Constructor'ı neden private olmak zorundadır?
    // CEVAP: Enum'lar Singleton (Tekil) tasarım desenine benzer çalışır. Dışarıdan "new CustomerType()" 
    // diyerek yeni bir nesne oluşturulmasına izin verilmez. Bellekte sadece yukarıdaki 3 sabit yaratılır.
    CustomerType(double discountMultiplier) {
        this.discountMultiplier = discountMultiplier;
    }

    public double getDiscountMultiplier() {
        return discountMultiplier;
    }
}