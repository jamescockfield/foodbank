package com.foodbank.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbank.data.User;
import com.foodbank.data.UserType;
import com.foodbank.data.repository.UserRepository;
import com.foodbank.utils.RequestValidator;

@RestController
public class AuthController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/api/auth")
    public String auth() {

        return "auth endpoint";
    }

    @PostMapping("/api/login")
    public ResponseEntity<HttpStatus> login(@RequestBody HashMap<String, String> request) {

        if (
            RequestValidator.validateEmail(request.get("email")) &&
            RequestValidator.validatePassword(request.get("password"))
        ) {

            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } else {

            return new ResponseEntity<HttpStatus>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @RequestMapping("/api/register")
    public ResponseEntity<HttpStatus> register(@RequestBody HashMap<String, String> request) {

        String email = request.get("email");
        String password = request.get("password");

        if (
            RequestValidator.validateEmail(email) &&
            RequestValidator.validatePassword(password)
        ) {

            User user = new User(UserType.VOLUNTEER, email, password);
            repository.save(user);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } else {

            return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
        }
    }
}
