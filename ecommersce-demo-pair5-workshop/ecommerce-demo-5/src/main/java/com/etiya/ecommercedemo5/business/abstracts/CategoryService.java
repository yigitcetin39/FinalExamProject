package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.CategoryDTO;
import com.etiya.ecommercedemo5.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo5.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Category;


import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(int id);

    AddCategoryResponse addCategory(AddCategoryRequest addCategoryRequest);

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.

    DataResult<List<CategoryDTO>> findByCategoryExample(int id);
    
}
