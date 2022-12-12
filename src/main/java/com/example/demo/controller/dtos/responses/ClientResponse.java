package com.example.demo.controller.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClientResponse {
    private Long id;

    private String name;

    private String product;

    private Long quantityOfProducts;

    private String typeOfService;

    private String token;
}
