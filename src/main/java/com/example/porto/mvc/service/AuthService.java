package com.example.porto.mvc.service;

import com.example.porto.mvc.model.Person;
import com.example.porto.mvc.model.dto.LoginRequest;
import com.example.porto.mvc.model.dto.RegisterRequest;
import com.example.porto.mvc.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private PersonRepository personRepo;


    public String register(RegisterRequest request) {
        try {
            personRepo.save(new Person(
                            UUID.randomUUID(),
                            request.getUsername(),
                            new Date(),
                            new Date(),
                            request.getPassword()
                    )
            );
            return "Register Successfully";
        } catch (Exception ex) {
            return "Failed :x: " + ex;
        }

    }
    public String login(LoginRequest request) {
        return "Login Successfully";
    }
}
