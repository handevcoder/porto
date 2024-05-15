package com.example.porto.mvc.service.impl;

import com.example.porto.mvc.model.Role;
import com.example.porto.mvc.model.User;
import com.example.porto.mvc.model.dto.RegisterRequest;
import com.example.porto.mvc.repository.UserRepository;
import com.example.porto.mvc.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signUp(RegisterRequest registerRequest) {
        User user = new User();

        user.setFirstname(registerRequest.getFirstname());
        user.setLastname(registerRequest.getLastname());
        user.setEmail(registerRequest.getEmail());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        return userRepository.save(user);
    }

}
