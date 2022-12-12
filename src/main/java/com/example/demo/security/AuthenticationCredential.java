package com.example.demo.security;

import lombok.Data;

@Data
public class AuthenticationCredential {
    private String email;
    private String password;
}
