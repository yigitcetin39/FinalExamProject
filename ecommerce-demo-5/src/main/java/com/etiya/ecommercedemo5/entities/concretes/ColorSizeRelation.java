package com.etiya.ecommercedemo5.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="color_size_relations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ColorSizeRelation {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="colorsid")
    private Color color;


    @ManyToOne
    @JoinColumn(name="sizeid")
    private Size size;









}
