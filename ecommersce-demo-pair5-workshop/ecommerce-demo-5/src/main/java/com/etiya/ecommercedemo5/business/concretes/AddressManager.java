package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.AddressService;
import com.etiya.ecommercedemo5.business.abstracts.AddressTitleService;
import com.etiya.ecommercedemo5.business.abstracts.CityService;
import com.etiya.ecommercedemo5.business.abstracts.CustomerService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.AddressDTO;
import com.etiya.ecommercedemo5.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo5.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Address;
import com.etiya.ecommercedemo5.entities.concretes.AddressTitle;
import com.etiya.ecommercedemo5.entities.concretes.City;
import com.etiya.ecommercedemo5.entities.concretes.Customer;
import com.etiya.ecommercedemo5.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemo5.repository.abstracts.AddressTitleRepository;
import com.etiya.ecommercedemo5.repository.abstracts.CityRepository;
import com.etiya.ecommercedemo5.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private AddressRepository addressRepository;
    private AddressTitleService addressTitleService;
    private CityService cityService;
    private CustomerService customerService;
    private CityRepository cityRepository;
    private ModelMapperService modelMapperService;
    private AddressTitleRepository addressTitleRepository;
    private CustomerRepository customerRepository;
    private MessageSource messageSource;

    @Override
    public DataResult<List<Address>> getAll() {
        List<Address> response = this.addressRepository.findAll();
        return new SuccessDataResult<List<Address>>(response,messageSource.getMessage(Messages.Address.getAllAddress,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Address> getById(int id) {
        Address response = this.addressRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Address>(response,messageSource.getMessage(Messages.Address.getByAddressId,null,LocaleContextHolder.getLocale()));
        //return checkIfAddressExistsById(address_id);
    }


    @Override
    public DataResult<List<Address>> getByName(String street) {
        List<Address> response = this.addressRepository.findByName(street);
        return new SuccessDataResult<List<Address>>(response,messageSource.getMessage(Messages.Address.getStreet,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<List<AddressDTO>> findByAddressExample(int id) {
        List<AddressDTO> response = addressRepository.findByAddressExample(id);
        return new SuccessDataResult<List<AddressDTO>>(response);
    }


    @Override
    public DataResult<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest) {


        checkIfExistsCityId(addAddressRequest.getCityId());
        checkIfExistsAddressTitleId(addAddressRequest.getAddressTitleId());
        checkIfExistsCustomerId(addAddressRequest.getCustomerId());


        // MAPPING => AUTO MAPPER

        /*Address address = new Address();
        address.setStreet(addAddressRequest.getStreet());



        checkIfExistsCityId(addAddressRequest.getCityId());

        City city = cityService.getById(addAddressRequest.getCityId());
        address.setCity(city);


        AddressTitle addressTitle = addressTitleService.getById(addAddressRequest.getAddrestitleId());
        address.setAddresstitle(addressTitle);

        Customer customer = customerService.getById(addAddressRequest.getCustomerId());
        address.setCustomers(customer);



        //
        // Business Rules
        // Validation
        Address savedAddress = addressRepository.save(address);

        // MAPPING -> Category => AddCategoryResponse
        AddAddressResponse response =
                new AddAddressResponse(savedAddress.getId(),
                        savedAddress.getCity().getId(),
                        savedAddress.getAddresstitle().getId(),
                        savedAddress.getStreet(),
                        savedAddress.getCustomers().getId()
                        );
        //
        return response;
*/

        Address address =
                modelMapperService.getMapper().map(addAddressRequest,Address.class);
        AddAddressResponse addAddressResponse =
                modelMapperService.getMapper().map(addressRepository.save(address),
                        AddAddressResponse.class);
        return new SuccessDataResult<AddAddressResponse>(addAddressResponse, messageSource.getMessage(Messages.Address.addAddress,null,LocaleContextHolder.getLocale()));
    }

    public void checkIfExistsCityId(int id){
        boolean isExists = cityRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(messageSource.getMessage(Messages.City.runTimeException,null, LocaleContextHolder.getLocale()));
        }
    }

    public void checkIfExistsAddressTitleId(int id){
        boolean isExists = addressTitleRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(messageSource.getMessage(Messages.AddressTitle.runTimeException,null, LocaleContextHolder.getLocale()));
        }
    }
    public void checkIfExistsCustomerId(int id){
        boolean isExists = customerRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(messageSource.getMessage(Messages.Customer.runTimeException,null, LocaleContextHolder.getLocale()));
        }
    }





        /*
        private City getCity(int cityid) {
            City city = cityService.getById(cityid);
            return city;
        }
        private AddressTitle getAddressTitle(int addresstitleid) {
            AddressTitle addresstitle = addressTitleService.getById(addresstitleid);
            return addresstitle;
        }

        private Customer getCustomer(int customerid) {
        Customer customer = customerService.getById(customerid);
        return customer;
        }
*/

}
