package com.example.demo.controller.dtos.responses;

import com.example.demo.entities.Client;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PetResponse {
    private Long id;

    private String name;

    private String breed;

    private String ownerPhone;

    private String client;
}
