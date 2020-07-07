package com.foodbank.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class routerController {

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

    @RequestMapping("/api/contact")
    public String contact() {
        return "this is the contact page";
    }
}
