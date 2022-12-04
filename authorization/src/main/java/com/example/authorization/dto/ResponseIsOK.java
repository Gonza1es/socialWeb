package com.example.authorization.dto;

public class ResponseIsOK implements Response{
    private String username;
    private String token;


    public ResponseIsOK(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }
}
