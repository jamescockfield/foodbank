package com.foodbank.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.web.csrf.CsrfToken;

import com.foodbank.security.BasicUserDetailsManager;

@RestController
public class AuthController {

    @Autowired BasicUserDetailsManager userDetailsManager;
    
    @GetMapping("/api/csrf")
    public CsrfToken csrf(CsrfToken token) {

        return token;
    }

    @GetMapping("/api/auth")
    public String auth() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authority = auth.getAuthorities().iterator().next().getAuthority();
        return authority;
    }

    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody HashMap<String, String> request) {

        String email = request.get("email");
        String password = request.get("password");
        String role = request.get("role") == "Manager" ? "ROLE_ADMIN" : "ROLE_USER";

        String[] params = {email, password, role};
        for (String param : params) {

            if (param == null || param.isEmpty()) {

                return new ResponseEntity<String>("Invalid request", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

        if (userDetailsManager.validateEmail(email)) {

            return new ResponseEntity<String>("Invalid email", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if (userDetailsManager.validatePassword(password)) {

            return new ResponseEntity<String>("Invalid password", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if (userDetailsManager.userExists(email)) {

            return new ResponseEntity<String>("Email already exists", HttpStatus.CONFLICT);
        }

        try {
            if (userDetailsManager.addUser(email, password, role).isEnabled()) {

                return new ResponseEntity<String>(HttpStatus.OK);
            } else {

                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (UsernameNotFoundException exception) {

            return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
