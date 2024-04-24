package com.example.porto.util.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<ApiResponse> success(String message, Object data, HttpStatus status) {
        ApiResponse response = new ApiResponse();
        response.setMessage(message);
        response.setData(data);
        response.setStatus(status.value());
        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<ApiResponse> error(String message, HttpStatus status) {
        ApiResponse response = new ApiResponse();
        response.setMessage(message);
        response.setStatus(status.value());
        return new ResponseEntity<>(response, status);
    }

}
