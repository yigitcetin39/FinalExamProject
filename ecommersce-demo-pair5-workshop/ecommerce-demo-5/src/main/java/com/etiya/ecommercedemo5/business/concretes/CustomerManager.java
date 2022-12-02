package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.CustomerService;

import com.etiya.ecommercedemo5.entities.concretes.Customer;
import com.etiya.ecommercedemo5.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id);
    }



    @Override
    public Customer getByFirstName(String name) {
        return customerRepository.findByCustomerFirstName(name);
    }

    @Override
    public Customer getByLastName(String name) {
        return customerRepository.findByCustomerLastName(name);
    }

    @Override
    public List<Customer> getAllNameAsc(int id) {
        return customerRepository.findAllCustomerByIdOrderByIdAsc(id);
    }

}
