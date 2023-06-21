package com.etiya.ecommercedemo5.business.abstracts;


import com.etiya.ecommercedemo5.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemo5.business.dtos.response.color.AddColorResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Color;
import com.etiya.ecommercedemo5.entities.concretes.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ColorService {
    DataResult<List<Color>> getAll();
    DataResult<Color> getById(int id);


    DataResult<AddColorResponse> addColor(AddColorRequest addColorRequest);

    DataResult<Page<Color>> findAllWithPagination(Pageable pageable);

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
}
