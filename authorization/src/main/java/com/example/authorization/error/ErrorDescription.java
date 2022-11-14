package com.example.authorization.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum ErrorDescription {

    WRONG_LOGIN_OR_PASSWORD("1", "Неверный логин или пароль"),
    EMAIL_ALREADY_EXISTS("2", "Такой email уже существует"),
    LOGIN_ALREADY_EXISTS("3", "Такой логин уже существует");


    private final String code;

    private final String message;


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    public ErrorException createException() {
        return new ErrorException(this.code, this.message);
    }


}
