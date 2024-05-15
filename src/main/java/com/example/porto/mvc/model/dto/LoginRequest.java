package com.example.porto.mvc.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class LoginRequest {

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

}
