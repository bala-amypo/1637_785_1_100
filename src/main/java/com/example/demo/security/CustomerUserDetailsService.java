package com.example.demo.security;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

public class CustomerUserDetailsService {

    private final UserService userService;

    public CustomerUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    public User loadUserByUsername(String email) {
        return userService.findByEmail(email);
    }
}
