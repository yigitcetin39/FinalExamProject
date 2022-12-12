package com.etiya.ecommercedemo5.api.controllers;


import com.etiya.ecommercedemo5.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemo5.business.dtos.request.productcategory.AddProductCategoryRequest;
import com.etiya.ecommercedemo5.business.dtos.response.productcategory.AddProductCategoryResponse;
import com.etiya.ecommercedemo5.entities.concretes.ProductCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productCategory")
public class ProductCategoryController {
    private ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService){
        this.productCategoryService=productCategoryService;
    }
    @GetMapping("/getAll")
    public List<ProductCategory> getAll() {
        return productCategoryService.getAll();
    }

    @GetMapping("{id}")
    public ProductCategory getById(@PathVariable int id){
        return productCategoryService.getById(id);
    }

    //@GetMapping("/getByProductCategory")
    // public List<ProductCategory> getByAllProductCategory(@RequestParam("id giriniz") int id);

    @PostMapping("/add")
    public ResponseEntity<AddProductCategoryResponse> addProductCategory
            (@RequestBody AddProductCategoryRequest addProductCategoryRequest){
        return new ResponseEntity<AddProductCategoryResponse>
                (productCategoryService.addProductCategory(addProductCategoryRequest), HttpStatus.CREATED);
    }
}
