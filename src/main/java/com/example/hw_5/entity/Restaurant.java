package com.example.hw_5.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
