package com.etiya.ecommercedemo5.business.abstracts;



import com.etiya.ecommercedemo5.business.dtos.request.cargo.AddCargoRequest;
import com.etiya.ecommercedemo5.business.dtos.response.cargo.AddCargoResponse;
import com.etiya.ecommercedemo5.entities.concretes.Cargo;

import java.util.List;

public interface CargoService {

    List<Cargo> getAll();
    Cargo getById(int id);
    List<Cargo> getAllByPriceGreaterThan(int price);
    Cargo getByName(String name);

    AddCargoResponse addCargo(AddCargoRequest addCargoRequest);
}
