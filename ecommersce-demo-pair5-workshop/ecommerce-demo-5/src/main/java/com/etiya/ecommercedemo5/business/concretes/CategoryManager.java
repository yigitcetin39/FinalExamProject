package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.CategoryService;
import com.etiya.ecommercedemo5.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo5.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.entities.concretes.Category;
import com.etiya.ecommercedemo5.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


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

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
    @Override
    public AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest) {
        // MAPPING => AUTO MAPPER
        Category category = new Category();
        categoryCanNotExistWithSameName(addCategoryRequest.getName());
        category.setName(addCategoryRequest.getName());
        category.setType(addCategoryRequest.getType());
        //
        // Business Rules
        // Validation
        Category savedCategory = categoryRepository.save(category);

        // MAPPING -> Category => AddCategoryResponse
        AddCategoryResponse response =
                new AddCategoryResponse(savedCategory.getId(), savedCategory.getName(), savedCategory.getType());
        //
        return response;
    }

    private void categoryCanNotExistWithSameName(String name){

        boolean isExists = categoryRepository.existsCategoryByName(name);
        if(isExists) // Veritabanımda bu isimde bir kategori mevcut!!

            throw new BusinessException("Bu isimle bir kategori zaten mevcut!");
    }





}
