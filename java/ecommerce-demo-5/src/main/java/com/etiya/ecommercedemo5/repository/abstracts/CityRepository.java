package com.etiya.ecommercedemo5.repository.abstracts;

import com.etiya.ecommercedemo5.entities.concretes.Cargo;
import com.etiya.ecommercedemo5.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface CityRepository extends JpaRepository<City,Integer> {



    // default olarak native SQL DEĞİL!
    // JPQL
    // :parametreIsmi
    @Query("Select c from City as c WHERE name=:name")
    City findByName(String name);


}
