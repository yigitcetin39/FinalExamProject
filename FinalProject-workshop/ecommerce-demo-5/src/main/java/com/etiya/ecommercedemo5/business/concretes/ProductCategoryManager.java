package com.etiya.ecommercedemo5.business.concretes;
import com.etiya.ecommercedemo5.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.productcategory.AddProductCategoryRequest;
import com.etiya.ecommercedemo5.business.dtos.response.productcategory.AddProductCategoryResponse;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import com.etiya.ecommercedemo5.entities.concretes.ProductCategory;
import com.etiya.ecommercedemo5.repository.abstracts.CategoryRepository;
import com.etiya.ecommercedemo5.repository.abstracts.ProductCategoryRepository;
import com.etiya.ecommercedemo5.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductCategoryManager implements ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;

    // private ModelMapper modelMapper;
    private ModelMapperService modelMapperService;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private MessageSource messageSource;

    @Override
    public DataResult<List<ProductCategory>> getAll() {
        List<ProductCategory> response = this.productCategoryRepository.findAll();
        return new SuccessDataResult<List<ProductCategory>>(response, messageSource.getMessage(Messages.ProductCategory.getAllProductCategory,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<ProductCategory> getById(int id) {
        ProductCategory response = this.productCategoryRepository.findById(id).orElseThrow();
        return new SuccessDataResult<ProductCategory>(response,messageSource.getMessage(Messages.ProductCategory.getByProductCategoryId,null,LocaleContextHolder.getLocale()));
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

        checkIfExistsCategoryId(addProductCategoryRequest.getCategoryId());
        checkIfExistsProductId(addProductCategoryRequest.getProductId());
        // MAPPING => AUTO MAPPER

        ProductCategory productCategory =
                modelMapperService.getMapper().map(addProductCategoryRequest,ProductCategory.class);
        AddProductCategoryResponse addProductCategoryResponse =
                modelMapperService.getMapper().map(productCategoryRepository.save(productCategory),
                        AddProductCategoryResponse.class);
        return new SuccessDataResult<AddProductCategoryResponse>(addProductCategoryResponse, messageSource.getMessage(Messages.ProductCategory.addProductCategory,null,LocaleContextHolder.getLocale()));
    }

    public void checkIfExistsProductId(int id){
        boolean isExists = productRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(messageSource.getMessage(Messages.Product.runTimeException,null, LocaleContextHolder.getLocale()));
        }
    }

    public void checkIfExistsCategoryId(int id){
        boolean isExists = categoryRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(messageSource.getMessage(Messages.Category.runTimeException,null, LocaleContextHolder.getLocale()));
        }
    }

    @Override
    public DataResult<Page<ProductCategory>> findAllWithPagination(Pageable pageable) {
        Page<ProductCategory> response = this.productCategoryRepository.findAll(pageable);
        return new SuccessDataResult<Page<ProductCategory>>(response,messageSource.getMessage(Messages.ProductCategory.getByPage,null,LocaleContextHolder.getLocale()));
    }
}