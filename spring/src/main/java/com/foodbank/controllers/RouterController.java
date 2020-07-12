package com.foodbank.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouterController {

    @RequestMapping("/api/index")
    public String index() {
        return "Greetings from spring boot!";
    }

    @RequestMapping("/api/collect")
    public String collect() {
        return "this is the collections page";
    }
    
    @RequestMapping("/api/donate")
    public String donate() {
        return "this is the donations page";
    }
}
