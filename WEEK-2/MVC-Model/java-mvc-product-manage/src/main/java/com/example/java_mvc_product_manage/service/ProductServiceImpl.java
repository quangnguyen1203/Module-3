package com.example.java_mvc_product_manage.service;

import com.example.java_mvc_product_manage.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer,Product> productMap;
    static {
        productMap = new HashMap<>();
//        productMap.put(1,new Product(1,"bc",500,"quang","quang"));
//        productMap.put(2,new Product(2,"bcd",500,"quang","quang"));
//        productMap.put(3,new Product(3,"bcf",500,"quang","quang"));
//        productMap.put(4,new Product(4,"bcg",500,"quang","quang"));
//        productMap.put(5,new Product(5,"j",500,"quang","quang"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
