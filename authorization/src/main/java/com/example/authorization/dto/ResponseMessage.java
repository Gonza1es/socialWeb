package com.example.authorization.dto;

public class ResponseMessage implements Response{
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
