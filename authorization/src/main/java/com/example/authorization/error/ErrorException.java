package com.example.authorization.error;

import lombok.Getter;

@Getter
public class ErrorException {

    private final String code;

    private final String message;

    public ErrorException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
