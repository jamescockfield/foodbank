package com.foodbank.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @RequestMapping("/api/auth")
    public String auth() {
        return "auth endpoint";
    }

    @RequestMapping("/api/login")
    public String login() {
        return "this is the login page";
    }

    @RequestMapping("/api/register")
    public String register() {
        return "this is the register page";
    }
}
