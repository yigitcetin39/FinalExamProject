package com.etiya.ecommercedemo5.business.dtos.request.colorsizerelation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddColorSizeRelationRequest {

    private int sizeId;
    private int colorId;

}
