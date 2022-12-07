package com.etiya.ecommercedemo5.api.controllers;


import com.etiya.ecommercedemo5.business.abstracts.CityService;

import com.etiya.ecommercedemo5.business.dtos.request.city.AddCityRequest;

import com.etiya.ecommercedemo5.business.dtos.response.city.AddCityResponse;

import com.etiya.ecommercedemo5.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {
    // DI
    @Autowired
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getAll")
    public List<City> getAll(){
        return cityService.getAll();
    }

    @GetMapping("/getById")
    public City getById(@RequestParam("id") int id){
        return cityService.getById(id);
    }

    @GetMapping("{id}")
    public City getByIdPath(@PathVariable int id){
        return cityService.getById(id);
    }


    @GetMapping("/getByName")
    public City getByName(@RequestParam("name") String name){
        return cityService.getByName(name);
    }

    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<AddCityResponse> addCity(@RequestBody AddCityRequest addCityRequest){
        return new ResponseEntity<AddCityResponse>(cityService.addCity(addCityRequest), HttpStatus.CREATED);
    }
}
