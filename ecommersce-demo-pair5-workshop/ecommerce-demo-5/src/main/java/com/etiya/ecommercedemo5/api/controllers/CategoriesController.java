package com.etiya.ecommercedemo5.api.controllers;

import com.etiya.ecommercedemo5.business.abstracts.CategoryService;
import com.etiya.ecommercedemo5.business.dtos.CategoryDTO;
import com.etiya.ecommercedemo5.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo5.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {
    private CategoryService categoryService;

    @GetMapping("")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<AddCategoryResponse> addCategory(@RequestBody @Valid AddCategoryRequest addCategoryRequest){
        return new ResponseEntity<AddCategoryResponse>(categoryService.addCategory(addCategoryRequest), HttpStatus.CREATED);
    }

    @GetMapping("/findByCategoryExampleDTO")
    public DataResult<List<CategoryDTO>> findByCategoryExample(int id){
        return this.categoryService.findByCategoryExample(id);
    }



}
