package com.etiya.ecommercedemo5.business.dtos.request.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddOrderRequest {
    private Date orderDate;
    private int customerId;
    private int addressId;
    private int paymentId;
    private int cargoId;
    private int productId;
}
