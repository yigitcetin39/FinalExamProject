package com.etiya.ecommercedemo5.business.abstracts;


import com.etiya.ecommercedemo5.business.dtos.request.addresstitle.AddAddressTitleRequest;
import com.etiya.ecommercedemo5.business.dtos.response.addresstitle.AddAddressTitleResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.AddressTitle;
import com.etiya.ecommercedemo5.entities.concretes.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface AddressTitleService {

    DataResult<List<AddressTitle>> getAll();
    DataResult<AddressTitle> getById(int id);
    DataResult<AddressTitle> getByName(String name);

    DataResult<AddAddressTitleResponse> addAddressTitle(AddAddressTitleRequest addressTitleRequest);

    DataResult<Page<AddressTitle>> findAllWithPagination(Pageable pageable);
}
