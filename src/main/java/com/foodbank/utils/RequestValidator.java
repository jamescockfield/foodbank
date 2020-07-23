package com.foodbank.utils;

import org.apache.commons.validator.routines.EmailValidator;

public class RequestValidator {

    public static boolean validateEmail(String email) {

        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    public static boolean validatePassword(String password) {
        
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}
