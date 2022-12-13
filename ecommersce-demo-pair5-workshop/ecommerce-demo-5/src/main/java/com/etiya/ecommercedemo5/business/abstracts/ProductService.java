package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.ProductDTO;
import com.etiya.ecommercedemo5.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<Product> getById(int id);
    DataResult<List<Product>> getAllByStockGreaterThan(double stock);
    DataResult<Product> getByName(String name);

    DataResult<List<Product>> getByNameStartingWith(String prefix);

    DataResult<List<Product>> getByNameLike(String name);

    DataResult<List<Product>> getByNameOrderAsc(String name);

    DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest);

    DataResult<List<Product>> getByExample(int colorsizeid);

    DataResult<List<ProductDTO>> findByExampleProduct(int id);

    DataResult<Page<Product>> findAllWithPagination(Pageable pageable);

    DataResult<Slice<Product>> findAllWithSlice(Pageable pageable);


}
