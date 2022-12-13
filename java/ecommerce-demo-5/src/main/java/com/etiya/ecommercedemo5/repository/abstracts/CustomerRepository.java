package com.etiya.ecommercedemo5.repository.abstracts;

import com.etiya.ecommercedemo5.entities.concretes.Customer;

import com.etiya.ecommercedemo5.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    @Query("SELECT c FROM Customer as c WHERE firstname=:name")
    Customer findByCustomerFirstName(String name);

    @Query("SELECT c FROM Customer as c WHERE lastname=:name")
    Customer findByCustomerLastName(String name);

    List<Customer> findAllCustomerByIdOrderByIdAsc(int id);

    List<Customer> findAll();

    Customer findById(int id);
}
