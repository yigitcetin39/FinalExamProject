package com.etiya.ecommercedemo5.repository.abstracts;

import com.etiya.ecommercedemo5.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
