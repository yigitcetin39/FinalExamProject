package com.etiya.ecommercedemo5.repository.abstracts;

import com.etiya.ecommercedemo5.business.dtos.CategoryDTO;
import com.etiya.ecommercedemo5.entities.concretes.Category;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    // ÖZEL QUERYLER
    boolean existsCategoryByName(String name);

    @Query("Select new com.etiya.ecommercedemo5.business.dtos.CategoryDTO" +
            "(ca.id,ca.name,ca.type)" +
            " from Category ca WHERE ca.id=:id")
    List<CategoryDTO> findByCategoryExample(int id);


}

