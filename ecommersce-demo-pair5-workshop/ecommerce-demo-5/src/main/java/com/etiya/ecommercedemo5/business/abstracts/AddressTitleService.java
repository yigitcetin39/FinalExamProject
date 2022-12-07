package com.etiya.ecommercedemo5.business.abstracts;


import com.etiya.ecommercedemo5.business.dtos.request.addresstitle.AddAddressTitleRequest;
import com.etiya.ecommercedemo5.business.dtos.response.addresstitle.AddAddressTitleResponse;
import com.etiya.ecommercedemo5.entities.concretes.AddressTitle;


import java.util.List;

public interface AddressTitleService {

    List<AddressTitle> getAll();
    AddressTitle getById(int id);
    AddressTitle getByName(String name);

    AddAddressTitleResponse addAddressTitle(AddAddressTitleRequest addressTitleRequest);
}
