package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.request.moneytype.AddMoneyTypeRequest;
import com.etiya.ecommercedemo5.business.dtos.response.moneytype.AddMoneyTypeResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.MoneyType;

import java.util.List;

public interface MoneyTypeService {

    DataResult<List<MoneyType>> getAll();
    DataResult<MoneyType> getById(int id);

    DataResult<MoneyType> getByName(String name);

    DataResult<AddMoneyTypeResponse> addMoneyType(AddMoneyTypeRequest addMoneyTypeRequest);
}
