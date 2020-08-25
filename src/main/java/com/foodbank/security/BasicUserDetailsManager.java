package com.foodbank.security;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

import org.apache.commons.validator.routines.EmailValidator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

public class BasicUserDetailsManager extends JdbcUserDetailsManager {

    @Setter private BCryptPasswordEncoder passwordEncoder;

    public UserDetails addUser(String email, String password, String role) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role));

        UserDetails user = new User(email, passwordEncoder.encode(password), authorities);
        super.createUser(user);

        return super.loadUserByUsername(email);
    }

    public boolean validateEmail(String email) {

        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    /**
     * Password must:
     * - contain at least 8 characters
     * - contain at least 1 letter, number, and special character
     */
    public boolean validatePassword(String password) {
        
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}
