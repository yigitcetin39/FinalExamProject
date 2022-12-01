package com.etiya.ecommercedemo5.entities.concretes;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;



}
