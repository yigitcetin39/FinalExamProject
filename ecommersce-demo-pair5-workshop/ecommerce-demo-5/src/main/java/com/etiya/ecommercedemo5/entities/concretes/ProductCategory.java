package com.etiya.ecommercedemo5.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productcategories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class ProductCategory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;


}