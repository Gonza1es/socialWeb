package com.example.authorization.error;

import com.example.authorization.dto.Response;
import lombok.Getter;

@Getter
public class ErrorException implements Response {

    private final String code;

    private final String message;

    public ErrorException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
