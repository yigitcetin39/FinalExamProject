package com.etiya.ecommercedemo5.api.controllers;


import com.etiya.ecommercedemo5.business.abstracts.ColorService;
import com.etiya.ecommercedemo5.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemo5.business.dtos.response.color.AddColorResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Color;
import com.etiya.ecommercedemo5.entities.concretes.Order;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public DataResult<List<Color>> getAll(){
        return colorService.getAll();
    }

    // client
    // server
    // DTO => Data Transfer Object
    // AddCategoryRequest => name,type
    // ResponseEntity
    @PostMapping("/add")
    public ResponseEntity<DataResult<AddColorResponse>> addColor(@RequestBody AddColorRequest addColorRequest){
        return new ResponseEntity<DataResult<AddColorResponse>>(colorService.addColor(addColorRequest), HttpStatus.CREATED);
    }

    @GetMapping("/api/getWithPagination")
    //RequestParam >> page.pageSize
    public DataResult<Page<Color>> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);

        return colorService.findAllWithPagination(pageable);

    }
}
