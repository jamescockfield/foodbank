package com.foodbank.controllers;

import org.apache.commons.validator.routines.EmailValidator;

import org.json.JSONObject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/api/contact")
    public String getContact() {
        return "this is the contact page";
    }
    
    @PostMapping("/api/contact")
    public ResponseEntity<HttpStatus> postContact(@RequestBody String requestString) {
        
        String email;
        JSONObject request;

        try {
            request = new JSONObject(requestString);
            email = request.getString("email");

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        EmailValidator validator = EmailValidator.getInstance();

        if (validator.isValid(email)) {

            System.out.println("Received contact form submission: " + request.toString());
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } else {

            return new ResponseEntity<HttpStatus>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
