package com.etiya.ecommercedemo5.repository.abstracts;

import com.etiya.ecommercedemo5.business.dtos.AddressDTO;
import com.etiya.ecommercedemo5.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("Select a from Address as a WHERE street=:name")
    List<Address> findByName(String name);


    @Query("Select new com.etiya.ecommercedemo5.business.dtos.AddressDTO(a.id,a.street)" +
            " from Address a WHERE a.id=:id")
    List<AddressDTO> findByAddressExample(int id);



}
