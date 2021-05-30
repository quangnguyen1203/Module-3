package com.example.customer_manage_jsp.model;

import java.io.Serializable;

public class Customer {
    private String name;
    private String dob;
    private String address;

    public Customer() {
    }

    public Customer(String name, String dob, String address) {
        this.name = name;
        this.dob = dob;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
