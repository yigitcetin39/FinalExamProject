package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.ProductDTO;
import com.etiya.ecommercedemo5.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    List<Product> getAllByStockGreaterThan(double stock);
    Product getByName(String name);

    List<Product> getByNameStartingWith(String prefix);

    List<Product> getByNameLike(String name);

    List<Product> getByNameOrderAsc(String name);

    AddProductResponse addProduct(AddProductRequest addProductRequest);

    List<Product> getByExample(int colorsizeid);

    DataResult<List<ProductDTO>> findByExampleProduct(int id);


}
