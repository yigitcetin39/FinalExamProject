package com.etiya.ecommercedemo5.business.abstracts;



import com.etiya.ecommercedemo5.business.dtos.request.cargo.AddCargoRequest;
import com.etiya.ecommercedemo5.business.dtos.response.cargo.AddCargoResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Cargo;
import com.etiya.ecommercedemo5.entities.concretes.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CargoService {

    DataResult<List<Cargo>> getAll();
    DataResult<Cargo> getById(int id);
    DataResult<List<Cargo>> getAllByPriceGreaterThan(int price);
    DataResult<Cargo> getByName(String name);

    DataResult<AddCargoResponse> addCargo(AddCargoRequest addCargoRequest);

    DataResult<Page<Cargo>> findAllWithPagination(Pageable pageable);
}
