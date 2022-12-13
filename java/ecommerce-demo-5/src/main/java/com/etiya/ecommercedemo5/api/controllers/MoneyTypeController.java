package com.etiya.ecommercedemo5.api.controllers;

import com.etiya.ecommercedemo5.business.abstracts.MoneyTypeService;
import com.etiya.ecommercedemo5.business.dtos.request.moneytype.AddMoneyTypeRequest;
import com.etiya.ecommercedemo5.business.dtos.response.moneytype.AddMoneyTypeResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.MoneyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moneytype")
public class MoneyTypeController {
    @Autowired
    private MoneyTypeService moneyTypeService;

    public MoneyTypeController(MoneyTypeService moneyTypeService) {
        this.moneyTypeService = moneyTypeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<MoneyType>> getAll(){
        return moneyTypeService.getAll();
    }
    @GetMapping("/getById")
    public DataResult<MoneyType> getById(@RequestParam("id") int id){
        return moneyTypeService.getById(id);
    }

    @GetMapping("/getByName")
    public DataResult<MoneyType> getByName(@RequestParam("Money Type  Name") String name){
        return moneyTypeService.getByName(name);
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddMoneyTypeResponse>> addMoneyType(@RequestBody AddMoneyTypeRequest addMoneyTypeRequest){
        return new ResponseEntity<DataResult<AddMoneyTypeResponse>>
                (moneyTypeService.addMoneyType(addMoneyTypeRequest), HttpStatus.CREATED);
    }

}
