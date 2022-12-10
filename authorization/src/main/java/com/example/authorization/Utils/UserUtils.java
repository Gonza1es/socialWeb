package com.example.authorization.Utils;

import com.example.authorization.security.jwt.JwtUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {

    public static JwtUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof JwtUser) {
            return (JwtUser) authentication.getPrincipal();
        }
        return null;
    }
}
