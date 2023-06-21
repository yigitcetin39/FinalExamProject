package com.etiya.ecommercedemo5.business.dtos.response.colorsizerelation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddColorSizeRelationResponse {
    private int colorSizeId;
    private int sizeid;
    private int colorid;
}