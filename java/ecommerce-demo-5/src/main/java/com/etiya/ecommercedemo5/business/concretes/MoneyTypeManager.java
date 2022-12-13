package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.MoneyTypeService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.moneytype.AddMoneyTypeRequest;
import com.etiya.ecommercedemo5.business.dtos.response.moneytype.AddMoneyTypeResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.MoneyType;
import com.etiya.ecommercedemo5.repository.abstracts.MoneyTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MoneyTypeManager implements MoneyTypeService {
    private MoneyTypeRepository moneyTypeRepository;

    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<MoneyType>> getAll() {
        List<MoneyType> response = this.moneyTypeRepository.findAll();
        return new SuccessDataResult<List<MoneyType>>(response, Messages.MoneyType.getAllMoneyType);
    }

    @Override
    public DataResult<MoneyType> getById(int id) {
        MoneyType response = this.moneyTypeRepository.findById(id).orElseThrow();
        return new SuccessDataResult<MoneyType>(response,Messages.MoneyType.getByMoneyTypeId);
    }

    @Override
    public DataResult<MoneyType> getByName(String name) {
        MoneyType response = this.moneyTypeRepository.findByName(name);
        return new SuccessDataResult<MoneyType>(response,Messages.MoneyType.getByMoneyTypeName);
    }

    @Override
    public DataResult<AddMoneyTypeResponse> addMoneyType(AddMoneyTypeRequest addMoneyTypeRequest) {

        MoneyType moneyType =
                modelMapperService.getMapper().map(addMoneyTypeRequest,MoneyType.class);
        AddMoneyTypeResponse addMoneyTypeResponse =
                modelMapperService.getMapper().map(moneyTypeRepository.save(moneyType),AddMoneyTypeResponse.class);
        return new SuccessDataResult<AddMoneyTypeResponse>(addMoneyTypeResponse,Messages.MoneyType.addMoneyType);
    }
}
