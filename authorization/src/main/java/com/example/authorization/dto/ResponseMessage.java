package com.example.authorization.dto;

public class ResponseMessage implements Response{
    private String message;

    private Boolean isFirstVisit;

    public ResponseMessage(String message, Boolean isFirstVisit) {
        this.message = message;
        this.isFirstVisit = isFirstVisit;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getFirstVisit() {
        return isFirstVisit;
    }
}
