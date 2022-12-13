package com.etiya.ecommercedemo5.business.abstracts;


import com.etiya.ecommercedemo5.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemo5.business.dtos.response.color.AddColorResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Color;

import java.util.List;

public interface ColorService {
    DataResult<List<Color>> getAll();
    DataResult<Color> getById(int id);


    DataResult<AddColorResponse> addColor(AddColorRequest addColorRequest);

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
}
