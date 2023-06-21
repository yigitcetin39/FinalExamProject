package com.etiya.ecommercedemo5.business.dtos.request.cargo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCargoRequest {
    private String name;
    private int price;
}
