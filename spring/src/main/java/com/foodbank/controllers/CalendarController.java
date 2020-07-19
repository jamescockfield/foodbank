package com.foodbank.controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarController {

    @GetMapping("/api/calendar")
    public ResponseEntity<HttpStatus> getCalendar() {

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/api/calendar")
    public ResponseEntity<HttpStatus> updateCalendar(@RequestBody HashMap<String, String> request) {

        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_IMPLEMENTED);
    }
}
