package com.hytech.logistics.model;

import com.hytech.logistics.enums.CustomerType;

/**
 * MÜLAKAT SORUSU: Encapsulation (Kapsülleme) prensibini neden uygularız?
 * CEVAP: Sınıfın iç durumunu (state) dış dünyadan gizlemek ve sadece bizim izin verdiğimiz 
 * metotlar (getter/setter) aracılığıyla kontrollü bir şekilde değiştirilmesini sağlamak için.
 * Bu sayede veri bütünlüğünü koruruz.
 */
public class Customer {
    private String id;
    private String fullName;
    private CustomerType customerType;

    public Customer(String id, String fullName, CustomerType customerType) {
        this.id = id;
        this.fullName = fullName;
        this.customerType = customerType;
    }

    // Getter metotları - Veriyi okumaya izin veriyoruz.
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    // MÜLAKAT EKRANI: Sadece gerekli alanlara Setter koymalıyız. 
    // Örneğin ID bir kere verildikten sonra değişmemeli, o yüzden setId() yazmıyoruz!
    public void setCustomerType(CustomerType customerType) {
        if (customerType == null) {
            throw new IllegalArgumentException("ID can't be empty!");
        }
        this.customerType = customerType;
    }
}