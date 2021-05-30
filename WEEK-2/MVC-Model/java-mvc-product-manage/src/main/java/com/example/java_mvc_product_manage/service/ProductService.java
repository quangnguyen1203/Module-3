package com.example.java_mvc_product_manage.service;

import com.example.java_mvc_product_manage.model.Product;

import java.beans.Customizer;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
