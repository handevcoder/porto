package com.example.porto.mvc.controller;

import com.example.porto.mvc.model.User;
import com.example.porto.mvc.model.dto.LoginRequest;
import com.example.porto.mvc.model.dto.RegisterRequest;
import com.example.porto.mvc.model.response.JwtAuthResponse;
import com.example.porto.mvc.service.AuthService;
import com.example.porto.mvc.service.AuthenticationService;
import com.example.porto.util.response.ApiResponse;
import com.example.porto.util.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @Autowired
    private AuthService authSvc;

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
        try {
            String response = authSvc.register(request);
            return ResponseHandler.success("Successfully", response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.error("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest request) {
        try {
            boolean response = authSvc.login(request);
            if (response) {
                return ResponseHandler.success("Login Successfully", response, HttpStatus.OK);

            } else {
                return ResponseHandler.success("Login Failed", response, HttpStatus.OK);
            }
        } catch (Exception e) {
            return ResponseHandler.error("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("registration")
    public ResponseEntity<User> registration(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("signin")
    public ResponseEntity<JwtAuthResponse> sign(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.sign(request));
    }



}
