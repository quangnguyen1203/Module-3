package com.example.CaseStudy.model;

import java.util.List;

public class Order {
    private int id;
    private Account customer;
    private List<Item> items;
    private long total;
    private int status;

    public Order() {
        this.status = 0;
    }

    public Order(int id, Account customer, List<Item> items, int status) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.status = status;
    }

    public Order(int id, Account customer, List<Item> items, long total, int status) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.total = total;
        this.status = status;
    }

    public Order(Account customer, List<Item> items, long total, int status) {
        this.customer = customer;
        this.items = items;
        this.total = total;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getCustomer() {
        return customer;
    }

    public void setCustomer(Account customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
