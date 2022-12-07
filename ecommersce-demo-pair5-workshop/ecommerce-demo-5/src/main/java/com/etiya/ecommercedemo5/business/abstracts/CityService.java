package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo5.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo5.entities.concretes.City;

import java.util.List;

public interface CityService {

    List<City> getAll();
    City getById(int id);
    City getByName(String name);





    AddCityResponse addCity(AddCityRequest addCityRequest);
}
