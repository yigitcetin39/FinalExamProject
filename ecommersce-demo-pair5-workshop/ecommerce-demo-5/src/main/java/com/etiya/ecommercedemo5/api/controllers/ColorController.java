package com.etiya.ecommercedemo5.api.controllers;


import com.etiya.ecommercedemo5.business.abstracts.ColorService;
import com.etiya.ecommercedemo5.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemo5.business.dtos.response.color.AddColorResponse;
import com.etiya.ecommercedemo5.entities.concretes.Color;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/color")
@AllArgsConstructor
public class ColorController {
    private ColorService colorService;

    @GetMapping("/getAll")
    public List<Color> getAll(){
        return colorService.getAll();
    }

    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<AddColorResponse> addColor(@RequestBody AddColorRequest addColorRequest){
        return new ResponseEntity<AddColorResponse>(colorService.addColor(addColorRequest), HttpStatus.CREATED);
    }
}
