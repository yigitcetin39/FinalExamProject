package com.etiya.ecommercedemo5.api.controllers;

import com.etiya.ecommercedemo5.business.abstracts.CustomerService;
import com.etiya.ecommercedemo5.business.abstracts.ProductService;
import com.etiya.ecommercedemo5.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemo5.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemo5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo5.entities.concretes.Customer;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    // DI
    @Autowired
    private CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAll")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/getById")
    public Customer getById(@RequestParam("id") int id){
        return customerService.getById(id);
    }
    @GetMapping("{id}")
    public Customer getByIdPath(@PathVariable int id){
        return customerService.getById(id);
    }

    @GetMapping("/getByFirstName")
    public Customer getByFirstName(@RequestParam("firstname") String name){
        return customerService.getByFirstName(name);
    }

    @GetMapping("/getByLastName")
    public Customer getByLastName(@RequestParam("lastname") String name){
        return customerService.getByLastName(name);
    }

    @GetMapping("/getCustomerInfo")
    public List<Customer> getAllNameAsc(@RequestParam("id giriniz") int id){
        return customerService.getAllNameAsc(id);
    }

    @PostMapping("/add")
    public ResponseEntity<AddCustomerResponse> addCustomer(@RequestBody AddCustomerRequest addCustomerRequest){
        return new ResponseEntity<AddCustomerResponse>(customerService.addCustomer(addCustomerRequest), HttpStatus.CREATED);
    }


    /*@GetMapping("/getByStockGreaterThan")
    public List<Product> getAllByStock(@RequestParam("stock") double stock){
        return productService.getAllByStockGreaterThan(stock);
    }*/
}
