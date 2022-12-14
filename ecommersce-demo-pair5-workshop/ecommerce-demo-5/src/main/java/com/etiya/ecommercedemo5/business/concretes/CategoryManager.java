package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.CategoryService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.CategoryDTO;
import com.etiya.ecommercedemo5.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo5.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Category;
import com.etiya.ecommercedemo5.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    private MessageSource messageSource;

    @Override
    public DataResult<List<Category>> getAll() {
        List<Category> response = this.categoryRepository.findAll();
        // SAYFALAMA
        // FİLTRELEME
        return new SuccessDataResult<List<Category>>(response,messageSource.getMessage(Messages.Category.getAllCategory,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Category> getById(int id) {
        Category response = this.categoryRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Category>(response, messageSource.getMessage(Messages.Category.getByCategoryId,null,LocaleContextHolder.getLocale()));
    }

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
    @Override
    public DataResult<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest) {
        // MAPPING => AUTO MAPPER
        /*Category category = new Category();
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
        return response;*/

        categoryCanNotExistWithSameName(addCategoryRequest.getName());

        Category category = modelMapperService.getMapper().map(addCategoryRequest,Category.class);

        //veritabanınında aynı isim bulunamaz
        //////// categoryCanNotExistWithSameName();
        // Validation
        Category savedCategory = categoryRepository.save(category);
        // MAPPING -> Category => AddCategoryResponse
        AddCategoryResponse response =
                modelMapperService.getMapper().map(savedCategory,AddCategoryResponse.class);

        return new SuccessDataResult<AddCategoryResponse>(response, messageSource.getMessage(Messages.Category.addCategory,null,LocaleContextHolder.getLocale()));


    }

    private void categoryCanNotExistWithSameName(String name){

        boolean isExists = categoryRepository.existsCategoryByName(name);
        if(isExists) // Veritabanımda bu isimde bir kategori mevcut!!

            throw new BusinessException(messageSource.getMessage(Messages.Category.CategoryExistsWithSameName,null,
                    LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<List<CategoryDTO>> findByCategoryExample(int id) {
        List<CategoryDTO> response = categoryRepository.findByCategoryExample(id);
        return new SuccessDataResult<List<CategoryDTO>>(response);
    }





}
