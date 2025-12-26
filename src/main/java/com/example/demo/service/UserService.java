package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User findById(Long id);  // make sure this exists
    User findByEmail(String email); // ADD THIS
    User save(User user);
}
