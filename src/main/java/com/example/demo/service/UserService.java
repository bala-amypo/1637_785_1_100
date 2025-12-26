package com.example.demo.service;

import com.example.demo.model.User;
import java.util.Optional;

public interface UserService {
    User save(User user);

    // make return type Optional<User> to match Spring Data style
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);
}
