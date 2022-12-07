package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemo5.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemo5.entities.concretes.Customer;



import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(int id);

    /* Customer getByName(String name); */

    Customer getByFirstName(String name);

    Customer getByLastName(String name);



    List<Customer> getAllNameAsc(int id);

    AddCustomerResponse addCustomer(AddCustomerRequest addCustomerRequest);
}
