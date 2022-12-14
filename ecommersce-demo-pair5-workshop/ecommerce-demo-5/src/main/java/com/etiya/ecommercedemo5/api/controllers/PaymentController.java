package com.etiya.ecommercedemo5.api.controllers;

import com.etiya.ecommercedemo5.business.abstracts.PaymentService;
import com.etiya.ecommercedemo5.business.dtos.request.payment.AddPaymentRequest;
import com.etiya.ecommercedemo5.business.dtos.response.payment.AddPaymentResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Payment;
import com.etiya.ecommercedemo5.entities.concretes.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Payment>> getAll(){
        return paymentService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Payment> getById(@RequestParam("id") int id){
        return paymentService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddPaymentResponse>> addPayment(@RequestBody AddPaymentRequest addPaymentRequest){
        return new ResponseEntity<DataResult<AddPaymentResponse>>(paymentService.addPayment(addPaymentRequest), HttpStatus.CREATED);
    }

    @GetMapping("/api/getWithPagination")
    //RequestParam >> page.pageSize
    public DataResult<Page<Payment>> getWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);

        return paymentService.findAllWithPagination(pageable);

    }
}
