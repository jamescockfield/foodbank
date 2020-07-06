package com.foodbank.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from spring boot!";
    }

    @RequestMapping("/collect")
    public String collect() {
        return "this is the collections page";
    }
    
    @RequestMapping("/donate")
    public String donate() {
        return "this is the donations page";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "this is the contact page";
    }
}
