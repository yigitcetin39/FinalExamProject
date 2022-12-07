package com.etiya.ecommercedemo5.repository.abstracts;

import com.etiya.ecommercedemo5.entities.concretes.Address;
import com.etiya.ecommercedemo5.entities.concretes.AddressTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("Select a from Address as a WHERE name=:name")
    AddressTitle findByName(String name);



}
