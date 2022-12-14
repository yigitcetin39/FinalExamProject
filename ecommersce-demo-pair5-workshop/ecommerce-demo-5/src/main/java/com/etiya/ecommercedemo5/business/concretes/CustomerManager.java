package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.CustomerService;

import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemo5.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Customer;
import com.etiya.ecommercedemo5.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;
    @Override
    public DataResult<List<Customer>> getAll() {
        List<Customer> response = this.customerRepository.findAll();
        return new SuccessDataResult<List<Customer>>(response, messageSource.getMessage(Messages.Customer.getAllCustomers,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Customer> getById(int id) {
        Customer response = this.customerRepository.findById(id);
        return new SuccessDataResult<Customer>(response, messageSource.getMessage(Messages.Customer.getByCustomerId,null,LocaleContextHolder.getLocale()));
    }



    @Override
    public DataResult<Customer> getByFirstName(String name) {
        Customer response = this.customerRepository.findByCustomerFirstName(name);
        return new SuccessDataResult<Customer>(response,messageSource.getMessage(Messages.Customer.getFirstName,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Customer> getByLastName(String name) {
        Customer response = this.customerRepository.findByCustomerLastName(name);
        return new SuccessDataResult<Customer>(response,messageSource.getMessage(Messages.Customer.getLastName,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<List<Customer>> getAllNameAsc(int id) {
        List<Customer> response = this.customerRepository.findAllCustomerByIdOrderByIdAsc(id);
        return new SuccessDataResult<List<Customer>>(response,messageSource.getMessage(Messages.Customer.getAllCustomers,null,LocaleContextHolder.getLocale()));
    }


    @Override
    public DataResult<AddCustomerResponse> addCustomer(AddCustomerRequest addCustomerRequest) {

        /*Customer customer = new Customer();
        customer.setFirstname(addCustomerRequest.getFirstname());
        customer.setLastname(addCustomerRequest.getLastname());
        customer.setPhonenumber(addCustomerRequest.getPhonenumber());
        customer.setBirthday(addCustomerRequest.getBirthday());
        Customer savedCustomer = customerRepository.save(customer);

        AddCustomerResponse response =
                new AddCustomerResponse(savedCustomer.getId(),savedCustomer.getFirstname(),savedCustomer.getLastname(),
                        savedCustomer.getPhonenumber(),savedCustomer.getBirthday());
        return response;*/

        Customer customer =
                modelMapperService.getMapper().map(addCustomerRequest,Customer.class);
        AddCustomerResponse addCustomerResponse =
                modelMapperService.getMapper().map(customerRepository.save(customer),AddCustomerResponse.class);
        return new SuccessDataResult<AddCustomerResponse>(addCustomerResponse,messageSource.getMessage(Messages.Customer.addCustomer,null, LocaleContextHolder.getLocale()));


    }


}
