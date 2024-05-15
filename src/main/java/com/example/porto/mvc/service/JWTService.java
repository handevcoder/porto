package com.example.porto.mvc.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public interface JWTService {
    String extractUserName(String token);
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);
    String generateRefreshToken(Map<String, Objects> extractClaims, UserDetails userDetails);
}
