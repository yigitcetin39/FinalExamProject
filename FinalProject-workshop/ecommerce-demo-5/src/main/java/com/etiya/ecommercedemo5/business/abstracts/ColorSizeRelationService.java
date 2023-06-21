package com.etiya.ecommercedemo5.business.abstracts;


import com.etiya.ecommercedemo5.business.dtos.request.colorsizerelation.AddColorSizeRelationRequest;
import com.etiya.ecommercedemo5.business.dtos.response.colorsizerelation.AddColorSizeRelationResponse;

import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.ColorSizeRelation;
import com.etiya.ecommercedemo5.entities.concretes.MoneyType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ColorSizeRelationService {

    DataResult<List<ColorSizeRelation>> getAll();
    DataResult<ColorSizeRelation> getById(int id);

    DataResult<AddColorSizeRelationResponse> addColorSizeRelation(AddColorSizeRelationRequest addColorSizeRelationRequest);

    DataResult<Page<ColorSizeRelation>> findAllWithPagination(Pageable pageable);

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
}
