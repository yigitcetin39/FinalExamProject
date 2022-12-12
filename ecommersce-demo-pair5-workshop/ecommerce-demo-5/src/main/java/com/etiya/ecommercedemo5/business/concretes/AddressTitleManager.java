package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.AddressTitleService;
import com.etiya.ecommercedemo5.business.dtos.request.addresstitle.AddAddressTitleRequest;
import com.etiya.ecommercedemo5.business.dtos.response.addresstitle.AddAddressTitleResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.entities.concretes.AddressTitle;
import com.etiya.ecommercedemo5.repository.abstracts.AddressTitleRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressTitleManager implements AddressTitleService {
    private AddressTitleRepository addressTitleRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<AddressTitle> getAll() {
        return addressTitleRepository.findAll();
    }

    @Override
    public AddressTitle getById(int id) {
        return addressTitleRepository.findById(id).orElseThrow();
    }


    @Override
    public AddressTitle getByName(String name) {
        return addressTitleRepository.findByName(name);
    }

    @Override
    public AddAddressTitleResponse addAddressTitle(AddAddressTitleRequest addAddressTitleRequest) {
        // MAPPING => AUTO MAPPER
        /*ddressTitle addressTitle = new AddressTitle();
        addressTitle.setName(addAddressTitleRequest.getName());

        //
        // Business Rules
        // Validation
        AddressTitle savedAddresTitle = addressTitleRepository.save(addressTitle);

        // MAPPING -> Category => AddCategoryResponse
        AddAddressTitleResponse response =
                new AddAddressTitleResponse(savedAddresTitle.getId(), savedAddresTitle.getName());
        //
        return response;*/

        // MAPPING => AUTO MAPPER
        AddressTitle addressTitle =
                modelMapperService.getMapper().map(addAddressTitleRequest,AddressTitle.class);
        AddAddressTitleResponse addAddressTitleResponse=
                modelMapperService.getMapper().map(addressTitleRepository.save(addressTitle),AddAddressTitleResponse.class);
        return addAddressTitleResponse;
    }
}
