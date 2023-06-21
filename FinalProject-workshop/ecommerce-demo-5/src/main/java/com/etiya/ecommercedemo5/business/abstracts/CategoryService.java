package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.CategoryDTO;
import com.etiya.ecommercedemo5.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo5.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Category;
import com.etiya.ecommercedemo5.entities.concretes.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface CategoryService {
    DataResult<List<Category>> getAll();
    DataResult<Category> getById(int id);

    DataResult<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest);

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.

    DataResult<List<CategoryDTO>> findByCategoryExample(int id);

    DataResult<Page<Category>> findAllWithPagination(Pageable pageable);
    
}
