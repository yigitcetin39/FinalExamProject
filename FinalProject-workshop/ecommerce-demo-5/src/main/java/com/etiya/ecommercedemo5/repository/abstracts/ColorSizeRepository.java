package com.etiya.ecommercedemo5.repository.abstracts;

import com.etiya.ecommercedemo5.entities.concretes.ColorSizeRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorSizeRepository extends JpaRepository<ColorSizeRelation,Integer> {
}
