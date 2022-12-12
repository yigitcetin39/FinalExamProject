package com.etiya.ecommercedemo5.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "name")
    private String name;

    @Column(name = "unitprice")
    private double unitprice;

    @Column(name = "stock")
    private double stock;

    @ManyToOne  //Eğer tabloda many gittiyse manytoOne yazılır
    @JoinColumn(name = "colorsizeid")
    @JsonIgnore
    private ColorSizeRelation colorSize;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Order> orders;

}