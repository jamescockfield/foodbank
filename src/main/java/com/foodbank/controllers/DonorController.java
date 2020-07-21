package com.foodbank.controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DonorController {

    @GetMapping("/api/donors")
    public ResponseEntity<HttpStatus> getDonors() {

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/api/donors/{$id}")
    public ResponseEntity<HttpStatus> getDonorDetails() {

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/api/donors")
    public ResponseEntity<HttpStatus> updateDonor(@RequestBody HashMap<String, String> request) {

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/api/donors/{$id}")
    public ResponseEntity<HttpStatus> deleteDonor() {

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_IMPLEMENTED);
    }
}
