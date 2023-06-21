package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemo5.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Customer;
import com.etiya.ecommercedemo5.entities.concretes.MoneyType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface CustomerService {
    DataResult<List<Customer>> getAll();
    DataResult<Customer> getById(int id);

    /* Customer getByName(String name); */

    DataResult<Customer> getByFirstName(String name);

    DataResult<Customer> getByLastName(String name);



    DataResult<List<Customer>> getAllNameAsc(int id);

    DataResult<AddCustomerResponse> addCustomer(AddCustomerRequest addCustomerRequest);

    DataResult<Page<Customer>> findAllWithPagination(Pageable pageable);
}
