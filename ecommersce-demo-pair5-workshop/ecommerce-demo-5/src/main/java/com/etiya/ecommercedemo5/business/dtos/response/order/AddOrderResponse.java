package com.etiya.ecommercedemo5.business.dtos.response.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddOrderResponse {
    private int id;
    private Date orderDate;
    private int customerId;
    private int addressId;
    private int paymentId;
    private int cargoId;
    private int productId;
}
