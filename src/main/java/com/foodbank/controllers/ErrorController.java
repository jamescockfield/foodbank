package com.foodbank.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public ResponseEntity<HttpStatus> handleError(HttpServletRequest request) {

        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setLocation(new URI("http://localhost:3000"));
        } catch (URISyntaxException exception) {
        }
        return new ResponseEntity<HttpStatus>(headers, HttpStatus.FOUND);
    }
} 
