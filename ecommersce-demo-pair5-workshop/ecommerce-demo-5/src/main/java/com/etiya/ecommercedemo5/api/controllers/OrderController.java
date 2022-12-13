package com.etiya.ecommercedemo5.api.controllers;

import com.etiya.ecommercedemo5.business.abstracts.OrderService;
import com.etiya.ecommercedemo5.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemo5.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Order;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    @GetMapping("/getAll")
    public DataResult<List<Order>> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Order> getById(int id) {
        return orderService.getById(id);
    }

    @GetMapping("/getByOrderDate")
    public DataResult<List<Order>> getByOrderDate(Date orderDate) {
        return orderService.getByOrderDate(orderDate);
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddOrderResponse>> addOrder(@RequestBody AddOrderRequest addOrderRequest){
        return new ResponseEntity<DataResult<AddOrderResponse>>(orderService.addOrder(addOrderRequest), HttpStatus.CREATED);
    }
    @GetMapping("/getALlOrderByCargoCompany")
    public DataResult<List<Order>> getALlOrderByCargoCompany(@RequestParam(value = "cargoCompany")String cargoCompany){
        return orderService.getALlOrderByCargoCompany(cargoCompany);
    }

    /*@GetMapping("/getAddressTitlesOfOrders")
    public DataResult<List<OrderDTO>> getAddressTitlesOfOrders(){
        return new SuccessDataResult<List<OrderDTO>>(orderService.getAddressTitlesOfOrders().getData());
    }*/
}
