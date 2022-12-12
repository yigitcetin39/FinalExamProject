package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.CityService;
import com.etiya.ecommercedemo5.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo5.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.entities.concretes.City;
import com.etiya.ecommercedemo5.repository.abstracts.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private CityRepository cityRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getById(int id) {
        return cityRepository.findById(id).orElseThrow();
    }


    @Override
    public City getByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public AddCityResponse addCity(AddCityRequest addCityRequest) {
        // MAPPING => AUTO MAPPER
        /*City city = new City();
        city.setName(addCityRequest.getName());

        //
        // Business Rules
        // Validation
        City savedCargo = cityRepository.save(city);

        // MAPPING -> Category => AddCategoryResponse
        AddCityResponse response =
                new AddCityResponse(savedCargo.getId(), savedCargo.getName());
        //
        return response;*/

        // MAPPING => AUTO MAPPER
        City city =
                modelMapperService.getMapper().map(addCityRequest,City.class);
        AddCityResponse addCityResponse =
                modelMapperService.getMapper().map(cityRepository.save(city),AddCityResponse.class);
        return addCityResponse;
    }
}
