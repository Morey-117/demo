package com.example.demo.controller.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClientRequest {
    private String name;

    private String product;

    private Long quantityOfProducts;

    private String typeOfService;
}
