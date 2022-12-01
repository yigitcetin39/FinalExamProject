package com.etiya.ecommercedemo5.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "payment")
    @JsonIgnore
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "moneytypeid")
    private MoneyType moneyType;

}