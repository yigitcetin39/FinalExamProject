package com.etiya.ecommercedemo5.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private java.sql.Date date;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customers;

    @ManyToOne
    @JoinColumn(name = "addressid")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "paymentid")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "cargoid")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;




}