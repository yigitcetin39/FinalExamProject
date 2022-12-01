package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.ProductService;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import com.etiya.ecommercedemo5.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    //DEPENDENCY INJECTION
    private ProductRepository productRepository;

    //Spring IoC


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }
}
