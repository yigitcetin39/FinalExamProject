package com.etiya.ecommercedemo5.api.controllers;

import com.etiya.ecommercedemo5.business.abstracts.AddressService;
import com.etiya.ecommercedemo5.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo5.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo5.entities.concretes.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    // DI
    @Autowired
    private AddressService addressService;


    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getAll")
    public List<Address> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/getById")
    public Address getById(@RequestParam("id") int id){
        return addressService.getById(id);
    }
    @GetMapping("{id}")
    public Address getByIdPath(@PathVariable int id){
        return addressService.getById(id);
    }


    @GetMapping("/getByStreet")
    public List<Address> getByStreet(@RequestParam("street") String street){
        return addressService.getByName(street);
    }



    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<AddAddressResponse> addAddress(@RequestBody AddAddressRequest addAddressRequest){
        return new ResponseEntity<AddAddressResponse>(addressService.addAddress(addAddressRequest), HttpStatus.CREATED);
    }
}
