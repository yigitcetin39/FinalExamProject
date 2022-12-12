package com.etiya.ecommercedemo5.api.controllers;

import com.etiya.ecommercedemo5.business.abstracts.PaymentService;
import com.etiya.ecommercedemo5.business.dtos.request.payment.AddPaymentRequest;
import com.etiya.ecommercedemo5.business.dtos.response.payment.AddPaymentResponse;
import com.etiya.ecommercedemo5.entities.concretes.Payment;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Payment> getAll(){
        return paymentService.getAll();
    }

    @GetMapping("/getById")
    public Payment getById(@RequestParam("id") int id){
        return paymentService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<AddPaymentResponse> addPayment(@RequestBody AddPaymentRequest addPaymentRequest){
        return new ResponseEntity<AddPaymentResponse>(paymentService.addPayment(addPaymentRequest), HttpStatus.CREATED);
    }
}
