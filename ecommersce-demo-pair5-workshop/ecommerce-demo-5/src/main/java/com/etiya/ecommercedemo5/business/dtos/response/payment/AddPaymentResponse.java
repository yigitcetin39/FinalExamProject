package com.etiya.ecommercedemo5.business.dtos.response.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentResponse {
    private int id;
    private String name;
    private int moneyTypeId;
}
