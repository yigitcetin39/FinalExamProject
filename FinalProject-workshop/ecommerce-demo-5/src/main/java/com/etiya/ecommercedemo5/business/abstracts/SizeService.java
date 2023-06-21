package com.etiya.ecommercedemo5.business.abstracts;


import com.etiya.ecommercedemo5.business.dtos.request.size.AddSizeRequest;
import com.etiya.ecommercedemo5.business.dtos.response.size.AddSizeResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import com.etiya.ecommercedemo5.entities.concretes.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SizeService {
    DataResult<List<Size>> getAllByStockGreaterThan(int stock);

    DataResult<List<Size>> getAll();

    DataResult<Size> getById(int id);

    DataResult<Size> getByName(String name);

    DataResult<AddSizeResponse> addSize(AddSizeRequest addSizeRequest);

    DataResult<Page<Size>> findAllWithPagination(Pageable pageable);
}
