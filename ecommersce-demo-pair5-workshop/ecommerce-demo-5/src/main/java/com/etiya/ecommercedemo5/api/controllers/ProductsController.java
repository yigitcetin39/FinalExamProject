package com.etiya.ecommercedemo5.api.controllers;

import com.etiya.ecommercedemo5.business.abstracts.ProductService;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {

    //DI


    private ProductService productService;

    /*
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
*/
    @GetMapping("/getAll")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable int id ){
        return productService.getById(id);
    }

    @GetMapping("/getById")
    public Product getByIdPath(@RequestParam int id ){
        return productService.getById(id);
    }
}
