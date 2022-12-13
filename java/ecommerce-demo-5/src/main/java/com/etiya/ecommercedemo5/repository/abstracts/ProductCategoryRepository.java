package com.etiya.ecommercedemo5.repository.abstracts;
import com.etiya.ecommercedemo5.entities.concretes.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
}
