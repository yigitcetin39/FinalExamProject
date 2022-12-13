package com.etiya.ecommercedemo5.business.concretes;


import com.etiya.ecommercedemo5.business.abstracts.CargoService;


import com.etiya.ecommercedemo5.business.dtos.request.cargo.AddCargoRequest;
import com.etiya.ecommercedemo5.business.dtos.response.cargo.AddCargoResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.entities.concretes.Cargo;

import com.etiya.ecommercedemo5.repository.abstracts.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CargoManager implements CargoService {

    private CargoRepository cargoRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<Cargo> getAll() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo getById(int id) {
        return cargoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Cargo> getAllByPriceGreaterThan(int price) {
        return cargoRepository.findAllCargosByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public Cargo getByName(String name) {
        return cargoRepository.findByName(name);
    }

    @Override
    public AddCargoResponse addCargo(AddCargoRequest addCargoRequest) {
        // MAPPING => AUTO MAPPER
        /*Cargo cargo = new Cargo();
        cargo.setName(addCargoRequest.getName());
        cargo.setPrice(addCargoRequest.getPrice());
        //
        // Business Rules
        // Validation
        Cargo savedCargo = cargoRepository.save(cargo);

        // MAPPING -> Category => AddCategoryResponse
        AddCargoResponse response =
                new AddCargoResponse(savedCargo.getId(), savedCargo.getName(), savedCargo.getPrice());
        //
        return response;*/

        Cargo cargo =
                modelMapperService.getMapper().map(addCargoRequest,Cargo.class);
        AddCargoResponse addCargoResponse =
                modelMapperService.getMapper().map(cargoRepository.save(cargo),AddCargoResponse.class);
        return addCargoResponse;
    }
}
