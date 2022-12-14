package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.AddressTitleService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.addresstitle.AddAddressTitleRequest;
import com.etiya.ecommercedemo5.business.dtos.response.addresstitle.AddAddressTitleResponse;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.AddressTitle;
import com.etiya.ecommercedemo5.entities.concretes.Cargo;
import com.etiya.ecommercedemo5.repository.abstracts.AddressTitleRepository;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressTitleManager implements AddressTitleService {
    private AddressTitleRepository addressTitleRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;
    @Override
    public DataResult<List<AddressTitle>> getAll() {
        List<AddressTitle> response = this.addressTitleRepository.findAll();
        return new SuccessDataResult<List<AddressTitle>>(response, messageSource.getMessage(Messages.AddressTitle.getAllAddressTitle,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<AddressTitle> getById(int id) {
        AddressTitle response = this.addressTitleRepository.findById(id).orElseThrow();
        return new SuccessDataResult<AddressTitle>(response, messageSource.getMessage(Messages.AddressTitle.getByAddressTitleId,null,LocaleContextHolder.getLocale()));
    }


    @Override
    public DataResult<AddressTitle> getByName(String name) {
        AddressTitle response = this.addressTitleRepository.findByName(name);
        return new SuccessDataResult<AddressTitle>(response,messageSource.getMessage(Messages.AddressTitle.getByAddressTitleName,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<AddAddressTitleResponse> addAddressTitle(AddAddressTitleRequest addAddressTitleRequest) {

        addressTitleCanNotExistWithSameName(addAddressTitleRequest.getName());
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
        return new SuccessDataResult<AddAddressTitleResponse>(addAddressTitleResponse, messageSource.getMessage(Messages.AddressTitle.addAddressTitle,null,LocaleContextHolder.getLocale()));
    }

    private void addressTitleCanNotExistWithSameName(String name){

        boolean isExists = addressTitleRepository.existsAddressTitleByName(name);
        if(isExists) // Veritabanımda bu isimde bir kategori mevcut!!

            throw new BusinessException(messageSource.getMessage(Messages.AddressTitle.AddressTitleExistsWithSameName,null,
                    LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Page<AddressTitle>> findAllWithPagination(Pageable pageable) {
        Page<AddressTitle> response = this.addressTitleRepository.findAll(pageable);
        return new SuccessDataResult<Page<AddressTitle>>(response,messageSource.getMessage(Messages.AddressTitle.getByPage,null,LocaleContextHolder.getLocale()));
    }
}
