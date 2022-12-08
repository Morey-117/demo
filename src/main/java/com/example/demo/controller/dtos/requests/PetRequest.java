package com.example.demo.controller.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PetRequest {
    private String name;

    private String breed;

    private String ownerPhone;

    private Long client;
}
