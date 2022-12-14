package com.etiya.ecommercedemo5.business.concretes;


import com.etiya.ecommercedemo5.business.abstracts.CargoService;


import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.cargo.AddCargoRequest;
import com.etiya.ecommercedemo5.business.dtos.response.cargo.AddCargoResponse;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Cargo;

import com.etiya.ecommercedemo5.entities.concretes.Category;
import com.etiya.ecommercedemo5.repository.abstracts.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class CargoManager implements CargoService {

    private CargoRepository cargoRepository;

    private ModelMapperService modelMapperService;
    private MessageSource messageSource;

    @Override
    public DataResult<List<Cargo>> getAll() {
        List<Cargo> response = this.cargoRepository.findAll();
        return new SuccessDataResult<List<Cargo>>(response, messageSource.getMessage(Messages.Cargo.getAllCargo,null,LocaleContextHolder.getLocale()));

    }

    @Override
    public DataResult<Cargo> getById(int id) {
        Cargo response = this.cargoRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Cargo>(response,messageSource.getMessage(Messages.Cargo.getByCargoId,null,LocaleContextHolder.getLocale()));

    }
    @Override
    public DataResult<List<Cargo>> getAllByPriceGreaterThan(int price) {
        List<Cargo> response = this.cargoRepository.findAllCargosByPriceGreaterThanOrderByPriceDesc(price);
        return new SuccessDataResult<List<Cargo>>(response,messageSource.getMessage(Messages.Cargo.getCargoPriceGreaterThan,null,LocaleContextHolder.getLocale()));

    }

    /* @Override
     public List<Cargo> getAllByPrice(int price) {
         return cargoRepository.findAllByPrice(price);
     }
     */
    @Override
    public DataResult<Cargo> getByName(String name) {
        Cargo response = this.cargoRepository.findByName(name);
        return new SuccessDataResult<Cargo>(response,messageSource.getMessage(Messages.Cargo.getByCargoName,null,LocaleContextHolder.getLocale()));
    }


    @Override
    public DataResult<AddCargoResponse> addCargo(AddCargoRequest addCargoRequest) {

        cargoCanNotExistWithSameName(addCargoRequest.getName());
        // MAPPING => AUTO MAPPER
        Cargo cargo =
                modelMapperService.getMapper().map(addCargoRequest,Cargo.class);
        AddCargoResponse addCargoResponse =
                modelMapperService.getMapper().map(cargoRepository.save(cargo),AddCargoResponse.class);
        return new SuccessDataResult<AddCargoResponse>(addCargoResponse,messageSource.getMessage(Messages.Cargo.addCargo,null,LocaleContextHolder.getLocale()));
    }

    private void cargoCanNotExistWithSameName(String name){

        boolean isExists = cargoRepository.existsCargoByName(name);
        if(isExists) // Veritabanımda bu isimde bir kargo mevcut!!

            throw new BusinessException(messageSource.getMessage(Messages.Cargo.CargoExistsWithSameName,null,
                    LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Page<Cargo>> findAllWithPagination(Pageable pageable) {
        Page<Cargo> response = this.cargoRepository.findAll(pageable);
        return new SuccessDataResult<Page<Cargo>>(response,messageSource.getMessage(Messages.Cargo.getByPage,null,LocaleContextHolder.getLocale()));
    }
}
