package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.AddressDTO;
import com.etiya.ecommercedemo5.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo5.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Address;


import java.util.List;

public interface AddressService {
    List<Address> getAll();
    Address getById(int id);

    List<Address> getByName(String street);

    AddAddressResponse addAddress(AddAddressRequest addAddressRequest);

    DataResult<List<AddressDTO>> findByAddressExample(int id);
}
