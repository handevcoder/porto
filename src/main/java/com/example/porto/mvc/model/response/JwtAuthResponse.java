package com.example.porto.mvc.model.response;

import lombok.Data;

@Data
public class JwtAuthResponse {
    private String token;
    private String refreshToken;
}
