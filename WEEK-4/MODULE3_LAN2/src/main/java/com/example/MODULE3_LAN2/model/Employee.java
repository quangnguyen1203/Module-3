package com.example.MODULE3_LAN2.model;

import com.mysql.cj.ParseInfo;

import java.sql.Date;

public class Employee {
    private int id;
    private String staffgroup;
    private String name;
    private Date dob;
    private String gender;
    private String phone;
    private int identity;
    private String email;
    private String address;

    public Employee() {
    }

    public Employee(int id, String staffgroup, String name, String gender, String phone) {
        this.id = id;
        this.staffgroup = staffgroup;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    public Employee(String staffgroup, String name, Date dob, String gender, String phone, int identity, String email, String address) {
        this.staffgroup = staffgroup;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.identity = identity;
        this.email = email;
        this.address = address;
    }

    public Employee(int id, String staffgroup, String name, Date dob, String gender, String phone, int identity, String email, String address) {
        this.id = id;
        this.staffgroup = staffgroup;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.identity = identity;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaffgroup() {
        return staffgroup;
    }

    public void setStaffgroup(String staffgroup) {
        this.staffgroup = staffgroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
