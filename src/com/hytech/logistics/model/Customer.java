package com.hytech.logistics.model;

import com.hytech.logistics.enums.CustomerType;


public class Customer {
    private String id;
    private String fullName;
    private CustomerType customerType;

    public Customer(String id, String fullName, CustomerType customerType) {
        this.id = id;
        this.fullName = fullName;
        this.customerType = customerType;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }


    public void setCustomerType(CustomerType customerType) {
        if (customerType == null) {
            throw new IllegalArgumentException("ID can't be empty!");
        }
        this.customerType = customerType;
    }
}