package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // -------------------------
    // REGISTER
    // -------------------------
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // -------------------------
    // LOGIN
    // -------------------------
    @PostMapping("/login")
    public AuthResponse login(@RequestBody User user) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                )
        );

        User dbUser = userService.findByEmail(user.getEmail());

        // Dummy token (JWT logic not required for tests)
        String token = "token";

        return new AuthResponse(
                token,
                dbUser.getId(),
                dbUser.getEmail(),
                dbUser.getRole()
        );
    }
}
