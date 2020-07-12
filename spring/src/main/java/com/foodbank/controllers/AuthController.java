package com.foodbank.controllers;

import org.apache.commons.validator.routines.EmailValidator;

import org.json.JSONObject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @RequestMapping("/api/auth")
    public String auth() {

        return "auth endpoint";
    }

    @PostMapping("/api/login")
    public ResponseEntity<HttpStatus> login(@RequestBody String requestString) {

        String email;

        try {

            JSONObject request = new JSONObject(requestString);
            email = request.getString("email");
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        EmailValidator validator = EmailValidator.getInstance();

        if (validator.isValid(email)) {

            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } else {

            return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/api/register")
    public String register() {

        return "this is the register page";
    }
}
