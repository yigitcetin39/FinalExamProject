package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.CategoryService;
import com.etiya.ecommercedemo5.entities.concretes.Category;
import com.etiya.ecommercedemo5.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        // SAYFALAMA
        // FİLTRELEME
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id).orElseThrow();
    }
}
