package com.example.porto.mvc.model.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
}
