package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.AddressService;
import com.etiya.ecommercedemo5.business.abstracts.AddressTitleService;
import com.etiya.ecommercedemo5.business.abstracts.CityService;
import com.etiya.ecommercedemo5.business.abstracts.CustomerService;
import com.etiya.ecommercedemo5.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo5.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo5.entities.concretes.Address;
import com.etiya.ecommercedemo5.entities.concretes.AddressTitle;
import com.etiya.ecommercedemo5.entities.concretes.City;
import com.etiya.ecommercedemo5.entities.concretes.Customer;
import com.etiya.ecommercedemo5.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemo5.repository.abstracts.CityRepository;
import lombok.AllArgsConstructor;
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

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(int id) {
        return addressRepository.findById(id).orElseThrow();
        //return checkIfAddressExistsById(address_id);
    }


    @Override
    public List<Address> getByName(String street) {
        return addressRepository.findByName(street);
    }

    @Override
    public AddAddressResponse addAddress(AddAddressRequest addAddressRequest) {
        // MAPPING => AUTO MAPPER

        Address address = new Address();
        address.setStreet(addAddressRequest.getStreet());



        checkIfExistsCityId(addAddressRequest.getCityid());

        City city = cityService.getById(addAddressRequest.getCityid());
        address.setCity(city);


        AddressTitle addressTitle = addressTitleService.getById(addAddressRequest.getAddrestitleid());
        address.setAddresstitle(addressTitle);

        Customer customer = customerService.getById(addAddressRequest.getCustomerid());
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

    }

    public void checkIfExistsCityId(int id){
        boolean isExists = cityRepository.existsById(id);
        if (!isExists){
            throw new RuntimeException("This city not found");
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
