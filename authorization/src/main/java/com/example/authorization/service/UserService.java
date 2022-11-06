package com.example.authorization.service;

import com.example.authorization.model.User;


public interface UserService {

    void register(User user);

    User findByUsername(String Username);

}
