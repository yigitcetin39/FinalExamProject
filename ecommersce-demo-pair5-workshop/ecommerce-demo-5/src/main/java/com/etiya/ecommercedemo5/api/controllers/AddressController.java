package com.etiya.ecommercedemo5.api.controllers;

import com.etiya.ecommercedemo5.business.abstracts.AddressService;
import com.etiya.ecommercedemo5.business.dtos.AddressDTO;
import com.etiya.ecommercedemo5.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo5.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
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
    public DataResult<List<Address>> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Address> getById(@RequestParam("id") int id){
        return addressService.getById(id);
    }
    @GetMapping("{id}")
    public DataResult<Address> getByIdPath(@PathVariable int id){
        return addressService.getById(id);
    }


    @GetMapping("/getByStreet")
    public DataResult<List<Address>> getByStreet(@RequestParam("street") String street){
        return addressService.getByName(street);
    }



    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<DataResult<AddAddressResponse>> addAddress(@RequestBody AddAddressRequest addAddressRequest){
        return new ResponseEntity<DataResult<AddAddressResponse>>(addressService.addAddress(addAddressRequest), HttpStatus.CREATED);
    }

    @GetMapping("/findByAddressExampleDTO")
    public DataResult<List<AddressDTO>> findByAddressExample(int id){
        return this.addressService.findByAddressExample(id);
    }
}
