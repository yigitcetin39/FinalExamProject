package com.etiya.ecommercedemo5.api.controllers;

import com.etiya.ecommercedemo5.business.abstracts.ProductService;
import com.etiya.ecommercedemo5.business.constants.Paths;
import com.etiya.ecommercedemo5.business.dtos.ProductDTO;
import com.etiya.ecommercedemo5.business.dtos.request.cargo.AddCargoRequest;
import com.etiya.ecommercedemo5.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo5.business.dtos.response.cargo.AddCargoResponse;
import com.etiya.ecommercedemo5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix + "products")
public class ProductsController {
    // DI
    @Autowired
    private ProductService productService;


    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Product> getById(@RequestParam("id") int id){
        return productService.getById(id);
    }
    @GetMapping("{id}")
    public DataResult<Product> getByIdPath(@PathVariable int id){
        return productService.getById(id);
    }

    @GetMapping("/getByStockGreaterThan")
    public DataResult<List<Product>> getAllByStock(@RequestParam("stock") double stock){
        return productService.getAllByStockGreaterThan(stock);
    }

    @GetMapping("/getByExample")
    public DataResult<List<Product>> getByExample(@RequestParam("colorsizeid") int colorsizeid){
        return productService.getByExample(colorsizeid);
    }

    @GetMapping("/getByName")
    public DataResult<Product> getByName(@RequestParam("name") String name){
        return productService.getByName(name);
    }

    @GetMapping("/getByNameStartingWith")
    public DataResult<List<Product>> getByNameStartingWith(@RequestParam("prefix") String prefix){
        return productService.getByNameStartingWith(prefix);
    }

    @GetMapping("/getByNameLike")
    public DataResult<List<Product>> getByNameLike(@RequestParam("name") String name){
        return productService.getByNameLike(name);
    }

    @GetMapping("/getByNameAsc")
    public DataResult<List<Product>> getByNameOrderAsc(@RequestParam("name") String name){
        return productService.getByNameOrderAsc(name);
    }

    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<DataResult<AddProductResponse>> addProduct(@RequestBody @Valid AddProductRequest addProductRequest){
        return new ResponseEntity<DataResult<AddProductResponse>>(productService.addProduct(addProductRequest), HttpStatus.CREATED);
    }


    @GetMapping("/findByExampleDTO")
    public DataResult<List<ProductDTO>> findByExample(int id){
        return this.productService.findByExampleProduct(id);
    }

    @GetMapping("/api/getWithPagination")
    //RequestParam >> page.pageSize
    public DataResult<Page<Product>> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);

        return productService.findAllWithPagination(pageable);

    }

    @GetMapping("/api/getWithSlice")
    //RequestParam >> page.pageSize
    public DataResult<Slice<Product>> getWithSlice(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);

        return productService.findAllWithSlice(pageable);

    }




}