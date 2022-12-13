package com.etiya.ecommercedemo5.business.concretes;


import com.etiya.ecommercedemo5.business.abstracts.ColorSizeRelationService;
import com.etiya.ecommercedemo5.business.abstracts.ProductService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.ProductDTO;
import com.etiya.ecommercedemo5.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import com.etiya.ecommercedemo5.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    //ColorsizeService Gelicek id için
    //private ColorSizeRelationService colorSizeRelationService;

    //ModelMapper
    private ColorSizeRelationService colorSizeRelationService;

    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<Product>> getByNameStartingWith(String prefix) {
        List<Product> response = this.productRepository.findByNameStartingWith(prefix);
        return new SuccessDataResult<List<Product>>(response, Messages.Product.getProductStartingWith);
    }

    @Override
    public DataResult<List<Product>> getByNameLike(String name) {
        List<Product> response = this.productRepository.findByNameIgnoreCaseContaining(name);
        return new SuccessDataResult<List<Product>>(response,Messages.Product.getProductLike);
    }

    @Override
    public DataResult<List<Product>> getAll() {
        List<Product> response = this.productRepository.findAll();
        return new SuccessDataResult<List<Product>>(response,Messages.Product.getAllProduct);
    }

    @Override
    public DataResult<Product> getById(int id) {
        Product response = this.productRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Product>(response,Messages.Product.getByProductId);
    }

    @Override
    public DataResult<List<Product>> getAllByStockGreaterThan(double stock) {
        List<Product> response = this.productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
        return new SuccessDataResult<List<Product>>(response,Messages.Product.getStockDesc);
    }

    @Override
    public DataResult<Product> getByName(String name) {
        Product response = this.productRepository.findByName(name);
        return new SuccessDataResult<Product>(response,Messages.Product.getByProductName);
    }


    @Override
    public DataResult<List<Product>> getByNameOrderAsc(String name) {
        List<Product> response = this.productRepository.findByNameOrderByNameAsc(name);
        return new SuccessDataResult<List<Product>>(response,Messages.Product.getByProductAllName);
    }

    @Override
    public DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest) {
        // MAPPING => AUTO MAPPER
        /*Product product = new Product();
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
        return response; */


        Product product =
                modelMapperService.getMapper().map(addProductRequest,Product.class);
        AddProductResponse addProductResponse =
                modelMapperService.getMapper().map(productRepository.save(product),AddProductResponse.class);
        return new SuccessDataResult<AddProductResponse>(addProductResponse,Messages.Product.addProduct);


    }

    @Override
    public DataResult<List<ProductDTO>> findByExampleProduct(int id) {
        List<ProductDTO> response = this.productRepository.findByExampleProduct(id);
        return new SuccessDataResult<List<ProductDTO>>(response); // mesaj yazınca gelmiyor

        //ProductDTO response = productRepository.findByExample(id);
        // return new SuccessDataResult<ProductDTO>(response,"Bu ürün listelendi"); (this.productRepository.findByExample(id)
    }


    @Override
    public DataResult<List<Product>> getByExample(int colorsizeid) {
        List<Product> response = this.productRepository.findByExample(colorsizeid);
        return new SuccessDataResult<List<Product>>(response,Messages.Product.getByColorSizeIdProduct);
    }

    @Override
    public DataResult<Page<Product>> findAllWithPagination(Pageable pageable) {
        Page<Product> response = this.productRepository.findAll(pageable);
        return new SuccessDataResult<Page<Product>>(response,Messages.Product.getByPage);
    }

    @Override
    public DataResult<Slice<Product>> findAllWithSlice(Pageable pageable) {
        Slice<Product> response = this.productRepository.getAllWithSlice(pageable);
        return new SuccessDataResult<Slice<Product>>(response,Messages.Product.getBySlice);
    }
}