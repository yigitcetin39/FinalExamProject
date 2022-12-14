package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.CityService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo5.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.City;
import com.etiya.ecommercedemo5.entities.concretes.Color;
import com.etiya.ecommercedemo5.repository.abstracts.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private CityRepository cityRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;
    @Override
    public DataResult<List<City>> getAll() {
        List<City> response = this.cityRepository.findAll();
        return new SuccessDataResult<List<City>>(response, messageSource.getMessage(Messages.City.getAllCities,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<City> getById(int id) {
        City response = this.cityRepository.findById(id).orElseThrow();
        return new SuccessDataResult<City>(response, messageSource.getMessage(Messages.City.getByCityId,null,LocaleContextHolder.getLocale()));
    }


    @Override
    public DataResult<City> getByName(String name) {
        City response = this.cityRepository.findByName(name);
        return new SuccessDataResult<City>(response,messageSource.getMessage(Messages.City.getByCityName,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest) {
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
        checkIfExistsCityName(addCityRequest.getName());

        City city =
                modelMapperService.getMapper().map(addCityRequest,City.class);
        AddCityResponse addCityResponse =
                modelMapperService.getMapper().map(cityRepository.save(city),AddCityResponse.class);
        return new SuccessDataResult<AddCityResponse>(addCityResponse,messageSource.getMessage(Messages.City.addCity,null,LocaleContextHolder.getLocale()));
    }

    public void checkIfExistsCityName(String name){
        boolean isExists=cityRepository.existsCityByName(name);
        if (isExists){
            throw new BusinessException(messageSource.getMessage(Messages.City.CityExistsWithSameName,null, LocaleContextHolder.getLocale()));
        }
    }

    @Override
    public DataResult<Page<City>> findAllWithPagination(Pageable pageable) {
        Page<City> response = this.cityRepository.findAll(pageable);
        return new SuccessDataResult<Page<City>>(response,messageSource.getMessage(Messages.City.getByPage,null,LocaleContextHolder.getLocale()));
    }
}
