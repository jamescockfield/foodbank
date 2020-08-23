package com.foodbank.controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodbank.utils.RequestValidator;

@RestController
public class ContactController {

    @GetMapping("/api/contact")
    public ResponseEntity<HttpStatus> getContact() {

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/api/contact")
    public ResponseEntity<HttpStatus> postContact(@RequestBody HashMap<String, String> request) {
        
        if (RequestValidator.validateEmail(request.get("email"))) {

            System.out.println("Received contact form submission: " + request);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } else {

            return new ResponseEntity<HttpStatus>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
