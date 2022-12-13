package com.etiya.ecommercedemo5.business.dtos.response.cargo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCargoResponse {
    private int id;
    private String name;
    private int price;
}
