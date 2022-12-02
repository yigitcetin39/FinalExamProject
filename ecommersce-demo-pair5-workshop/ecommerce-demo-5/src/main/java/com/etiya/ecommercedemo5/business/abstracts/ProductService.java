package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    List<Product> getAllByStockGreaterThan(double stock);
    Product getByName(String name);
}
