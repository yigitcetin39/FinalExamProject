package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo5.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.City;
import com.etiya.ecommercedemo5.entities.concretes.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();
    DataResult<City> getById(int id);
    DataResult<City> getByName(String name);
    DataResult<Page<City>> findAllWithPagination(Pageable pageable);





    DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest);
}
