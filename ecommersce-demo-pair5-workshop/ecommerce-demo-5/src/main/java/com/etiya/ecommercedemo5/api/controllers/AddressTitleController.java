package com.etiya.ecommercedemo5.api.controllers;

import com.etiya.ecommercedemo5.business.abstracts.AddressTitleService;
import com.etiya.ecommercedemo5.business.dtos.request.addresstitle.AddAddressTitleRequest;
import com.etiya.ecommercedemo5.business.dtos.response.addresstitle.AddAddressTitleResponse;
import com.etiya.ecommercedemo5.entities.concretes.AddressTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addressTitle")
public class AddressTitleController {
    // DI
    @Autowired
    private AddressTitleService addressTitleService;

    public AddressTitleController(AddressTitleService addressTitleService) {
        this.addressTitleService = addressTitleService;
    }

    @GetMapping("/getAll")
    public List<AddressTitle> getAll(){
        return addressTitleService.getAll();
    }

    @GetMapping("/getById")
    public AddressTitle getById(@RequestParam("id") int id){
        return addressTitleService.getById(id);
    }
    @GetMapping("{id}")
    public AddressTitle getByIdPath(@PathVariable int id){
        return addressTitleService.getById(id);
    }


    @GetMapping("/getByName")
    public AddressTitle getByName(@RequestParam("name") String name){
        return addressTitleService.getByName(name);
    }

    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<AddAddressTitleResponse> addAddressTitle(@RequestBody AddAddressTitleRequest addAddressTitleRequest){
        return new ResponseEntity<AddAddressTitleResponse>(addressTitleService.addAddressTitle(addAddressTitleRequest), HttpStatus.CREATED);
    }


}
