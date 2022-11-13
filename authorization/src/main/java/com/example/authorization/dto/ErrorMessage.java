package com.example.authorization.dto;

public class ErrorMessage {

    private final String description;

    public ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
