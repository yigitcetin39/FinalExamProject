package com.etiya.ecommercedemo5.business.dtos.response.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddProductResponse {
    private int id;
    private String name;
    private double unitPrice;
    private double stock;
    private int colorSizeId;
}
