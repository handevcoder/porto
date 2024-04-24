package com.example.porto.util.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ModelResponse<T> {
    private boolean success;
    private String message;
    private T data;
}
