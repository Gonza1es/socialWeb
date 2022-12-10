package com.example.authorization.service;

import com.example.authorization.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void register(User user);

    User getUserByUsername(String Username);

    void setFirstVisit();

}
