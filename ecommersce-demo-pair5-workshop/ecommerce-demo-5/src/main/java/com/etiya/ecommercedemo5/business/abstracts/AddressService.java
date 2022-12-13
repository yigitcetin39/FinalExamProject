package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.AddressDTO;
import com.etiya.ecommercedemo5.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo5.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Address;


import java.util.List;

public interface AddressService {
    DataResult<List<Address>> getAll();
    DataResult<Address> getById(int id);

    DataResult<List<Address>> getByName(String street);

    DataResult<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest);

    DataResult<List<AddressDTO>> findByAddressExample(int id);
}
