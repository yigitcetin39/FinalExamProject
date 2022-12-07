package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.ColorSizeRelationService;
import com.etiya.ecommercedemo5.business.abstracts.ProductService;
import com.etiya.ecommercedemo5.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo5.entities.concretes.ColorSizeRelation;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import com.etiya.ecommercedemo5.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    //ColorsizeService Gelicek id için
    private ColorSizeRelationService colorSizeRelationService;



    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAllByStockGreaterThan(double stock) {
        return productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
    }

    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getByNameStartingWith(String prefix) {
        return productRepository.findByNameStartingWith(prefix);
    }

    @Override
    public List<Product> getByNameLike(String name) {
        return productRepository.findByNameIgnoreCaseContaining(name);
    }

    @Override
    public List<Product> getByNameOrderAsc(String name) {
        return productRepository.findByNameOrderByNameAsc(name);
    }

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        // MAPPING => AUTO MAPPER
        Product product = new Product();
        product.setName(addProductRequest.getName());
        product.setUnitprice(addProductRequest.getUnitPrice());
        product.setStock(addProductRequest.getStock());

        ColorSizeRelation colorSizeRelation = colorSizeRelationService.getById(addProductRequest.getColorsizeid());
        product.setColorSizeRelation(colorSizeRelation);


        //
        // Business Rules
        // Validation
        Product savedProduct = productRepository.save(product);

        // MAPPING -> Category => AddCategoryResponse
        AddProductResponse response =
                new AddProductResponse(savedProduct.getId(), savedProduct.getName(), savedProduct.getUnitprice(),
                        savedProduct.getStock(),savedProduct.getColorSizeRelation().getId());
        //
        return response;
    }





}