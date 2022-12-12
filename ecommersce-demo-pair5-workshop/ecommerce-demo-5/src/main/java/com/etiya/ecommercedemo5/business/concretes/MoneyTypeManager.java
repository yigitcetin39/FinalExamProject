package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.MoneyTypeService;
import com.etiya.ecommercedemo5.business.dtos.request.moneytype.AddMoneyTypeRequest;
import com.etiya.ecommercedemo5.business.dtos.response.moneytype.AddMoneyTypeResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
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
    public List<MoneyType> getAll() {
        return null;
    }

    @Override
    public MoneyType getById(int id) {
        return moneyTypeRepository.findById(id).orElseThrow();
    }

    @Override
    public MoneyType getByName(String name) {
        return moneyTypeRepository.findByName(name);
    }

    @Override
    public AddMoneyTypeResponse addMoneyType(AddMoneyTypeRequest addMoneyTypeRequest) {

        MoneyType moneyType =
                modelMapperService.getMapper().map(addMoneyTypeRequest,MoneyType.class);
        AddMoneyTypeResponse addMoneyTypeResponse =
                modelMapperService.getMapper().map(moneyTypeRepository.save(moneyType),AddMoneyTypeResponse.class);
        return addMoneyTypeResponse;
    }
}
