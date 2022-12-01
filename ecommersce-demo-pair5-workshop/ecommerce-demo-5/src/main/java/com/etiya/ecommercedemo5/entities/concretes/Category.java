package com.etiya.ecommercedemo5.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")

public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category" )
    @JsonIgnore
    private List<ProductCategory> productCategories;

    @Entity
    @Table(name = "cargo")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor


    public static class Cargo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "name")
        private String name;

        @OneToMany(mappedBy = "cargo")
        @JsonIgnore
        private List<Order> orders;


    }
}
