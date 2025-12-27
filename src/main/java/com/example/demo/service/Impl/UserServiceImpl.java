package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Optional<User> findById(Long id) {
       
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
       
        return Optional.empty();
    }

    @Override
    public User save(User user) {
       
        return user;
    }
}
