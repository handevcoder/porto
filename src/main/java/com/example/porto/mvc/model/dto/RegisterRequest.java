package com.example.porto.mvc.model.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
//    @Column(name = "phone")
//    private String phone;
//    @Column(name = "email")
//    private String email;
}
