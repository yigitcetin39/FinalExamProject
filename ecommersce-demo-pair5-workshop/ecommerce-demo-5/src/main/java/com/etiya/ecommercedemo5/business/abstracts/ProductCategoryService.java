package com.etiya.ecommercedemo5.business.abstracts;
import com.etiya.ecommercedemo5.business.dtos.request.productcategory.AddProductCategoryRequest;
import com.etiya.ecommercedemo5.business.dtos.response.productcategory.AddProductCategoryResponse;
import com.etiya.ecommercedemo5.entities.concretes.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getAll();

    ProductCategory getById(int id);

    AddProductCategoryResponse addProductCategory(AddProductCategoryRequest addProductCategoryRequest);
}
