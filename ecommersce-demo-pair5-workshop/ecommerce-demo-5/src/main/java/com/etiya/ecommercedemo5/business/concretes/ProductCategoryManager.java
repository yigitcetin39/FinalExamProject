package com.etiya.ecommercedemo5.business.concretes;
import com.etiya.ecommercedemo5.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.productcategory.AddProductCategoryRequest;
import com.etiya.ecommercedemo5.business.dtos.response.productcategory.AddProductCategoryResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
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
    public DataResult<List<ProductCategory>> getAll() {
        List<ProductCategory> response = this.productCategoryRepository.findAll();
        return new SuccessDataResult<List<ProductCategory>>(response, Messages.ProductCategory.getAllProductCategory);
    }

    @Override
    public DataResult<ProductCategory> getById(int id) {
        ProductCategory response = this.productCategoryRepository.findById(id).orElseThrow();
        return new SuccessDataResult<ProductCategory>(response,Messages.ProductCategory.getByProductCategoryId);
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
    public DataResult<AddProductCategoryResponse> addProductCategory(AddProductCategoryRequest addProductCategoryRequest) {
        // MAPPING => AUTO MAPPER

        ProductCategory productCategory =
                modelMapperService.getMapper().map(addProductCategoryRequest,ProductCategory.class);
        AddProductCategoryResponse addProductCategoryResponse =
                modelMapperService.getMapper().map(productCategoryRepository.save(productCategory),
                        AddProductCategoryResponse.class);
        return new SuccessDataResult<AddProductCategoryResponse>(addProductCategoryResponse, Messages.ProductCategory.addProductCategory);
    }
}