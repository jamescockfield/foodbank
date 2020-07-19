package com.foodbank.controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public ResponseEntity<HttpStatus> getUsers() {

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/api/users/{$id}")
    public ResponseEntity<HttpStatus> getUserDetails(@PathVariable("id") Integer id) {

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/api/users")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody HashMap<String, String> request) {

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/api/users/{$id}")
    public ResponseEntity<HttpStatus> deleteUser() {

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_IMPLEMENTED);
    }
}
