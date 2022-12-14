package com.etiya.ecommercedemo5.business.dtos.request.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddPaymentRequest {
    private String name;
    private int moneyTypeId;
}
