package com.etiya.ecommercedemo5.business.abstracts;


import com.etiya.ecommercedemo5.business.dtos.request.size.AddSizeRequest;
import com.etiya.ecommercedemo5.business.dtos.response.size.AddSizeResponse;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import com.etiya.ecommercedemo5.entities.concretes.Size;

import java.util.List;

public interface SizeService {
    List<Size> getAllByStockGreaterThan(int stock);

    List<Size> getAll();

    Size getById(int id);

    Size getByName(String name);

    AddSizeResponse addSize(AddSizeRequest addSizeRequest);
}
