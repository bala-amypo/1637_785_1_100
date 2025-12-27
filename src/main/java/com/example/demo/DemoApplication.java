package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("monesh"));
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		if(encoder.matches("monesh", "$2a$10$qTNOcEcfXwcrwZ6uP0jVY.GfpVS97EXU7MBYVZ7FPT9RrFNUo/n9O")){
			System.out.println("password matched");
		}else{
			System.out.println("no match");
		}
	}
}

