package com.example.authorization.dto;

import lombok.Data;

@Data
public class AddProfileInfo {

    private String alias;
    private String status;

    public AddProfileInfo(String alias, String status) {
        this.alias = alias;
        this.status = status;
    }
}
