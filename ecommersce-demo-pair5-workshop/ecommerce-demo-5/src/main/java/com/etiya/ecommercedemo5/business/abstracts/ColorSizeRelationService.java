package com.etiya.ecommercedemo5.business.abstracts;


import com.etiya.ecommercedemo5.business.dtos.request.colorsizerelation.AddColorSizeRelationRequest;
import com.etiya.ecommercedemo5.business.dtos.response.colorsizerelation.AddColorSizeRelationResponse;

import com.etiya.ecommercedemo5.entities.concretes.ColorSizeRelation;

import java.util.List;

public interface ColorSizeRelationService {

    List<ColorSizeRelation> getAll();
    ColorSizeRelation getById(int id);

    AddColorSizeRelationResponse addColorSizeRelation(AddColorSizeRelationRequest addColorSizeRelationRequest);

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
}
