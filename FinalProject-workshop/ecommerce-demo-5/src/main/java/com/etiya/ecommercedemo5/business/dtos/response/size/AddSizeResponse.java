package com.etiya.ecommercedemo5.business.dtos.response.size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddSizeResponse {
    private int id;
    private String name;
    private int stock;
}
