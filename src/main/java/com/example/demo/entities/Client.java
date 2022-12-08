package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter @Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String product;

    private Long quantityOfProducts;

    private String typeOfService;

    @OneToOne(mappedBy = "client")
    private Pet pet;
}
