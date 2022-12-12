package com.etiya.ecommercedemo5.business.concretes;
import com.etiya.ecommercedemo5.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemo5.business.dtos.request.productcategory.AddProductCategoryRequest;
import com.etiya.ecommercedemo5.business.dtos.response.productcategory.AddProductCategoryResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.entities.concretes.ProductCategory;
import com.etiya.ecommercedemo5.repository.abstracts.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductCategoryManager implements ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;

    // private ModelMapper modelMapper;
    private ModelMapperService modelMapperService;

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory getById(int id) {
        return productCategoryRepository.findById(id).orElseThrow();
    }

    /*@Override
    public List<ProductCategory> getByProductId(int id) {
        return productCategoryRepository.findByProductId(id);
    }
     */

    /*  @Override
      public List<ProductCategory> getByCategoryId(int id) {
          return productCategoryRepository.findByCategoryId(id);
      }
  */
    @Override
    public AddProductCategoryResponse addProductCategory(AddProductCategoryRequest addProductCategoryRequest) {
        // MAPPING => AUTO MAPPER

        ProductCategory productCategory =
                modelMapperService.getMapper().map(addProductCategoryRequest,ProductCategory.class);
        AddProductCategoryResponse addProductCategoryResponse =
                modelMapperService.getMapper().map(productCategoryRepository.save(productCategory),
                        AddProductCategoryResponse.class);
        return addProductCategoryResponse;
    }
}