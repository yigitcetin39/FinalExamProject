package com.etiya.ecommercedemo5.business.concretes;


import com.etiya.ecommercedemo5.business.abstracts.CargoService;
import com.etiya.ecommercedemo5.entities.concretes.Cargo;

import com.etiya.ecommercedemo5.repository.abstracts.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CargoManager implements CargoService {

    private CargoRepository cargoRepository;
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
}
