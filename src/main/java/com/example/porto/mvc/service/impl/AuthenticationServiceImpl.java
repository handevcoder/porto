package com.example.porto.mvc.service.impl;

import com.example.porto.mvc.model.Role;
import com.example.porto.mvc.model.User;
import com.example.porto.mvc.model.dto.LoginRequest;
import com.example.porto.mvc.model.dto.RegisterRequest;
import com.example.porto.mvc.model.response.JwtAuthResponse;
import com.example.porto.mvc.repository.UserRepository;
import com.example.porto.mvc.service.AuthenticationService;
import com.example.porto.mvc.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public User signUp(RegisterRequest registerRequest) {
        User user = new User();

        user.setFirstname(registerRequest.getFirstname());
        user.setLastname(registerRequest.getLastname());
        user.setEmail(registerRequest.getEmail());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User signup(RegisterRequest request) {
        User user = new User();

        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public JwtAuthResponse sign(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException(""));
        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();

        jwtAuthResponse.setToken(jwt);
        jwtAuthResponse.setRefreshToken(refreshToken);

        return jwtAuthResponse;
    }
}
