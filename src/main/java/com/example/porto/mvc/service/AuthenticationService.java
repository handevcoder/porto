package com.example.porto.mvc.service;

import com.example.porto.mvc.model.User;
import com.example.porto.mvc.model.dto.LoginRequest;
import com.example.porto.mvc.model.dto.RegisterRequest;
import com.example.porto.mvc.model.response.JwtAuthResponse;

public interface AuthenticationService {
    User signup(RegisterRequest request);
    JwtAuthResponse sign(LoginRequest request);
}
