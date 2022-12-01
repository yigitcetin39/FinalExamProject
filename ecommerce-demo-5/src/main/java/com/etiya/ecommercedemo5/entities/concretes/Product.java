package com.etiya.ecommercedemo5.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="unit_price")
    private double unit_price;

    @Column(name="stock")
    private double stock;

    @ManyToOne
    @JoinColumn(name="colorsizeid")
    @JsonIgnore
    private ColorSizeRelation colorSizeRelation;


}
