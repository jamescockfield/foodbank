package com.foodbank.unit.authentication;

import org.junit.jupiter.api.Test;

import com.foodbank.security.BasicUserDetailsManager;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicUserDetailsManagerTest {

    private BasicUserDetailsManager userDetailsManager;

    @Test
    public void testValidation() {

        assertFalse(userDetailsManager.validateEmail("invalidemail"));
        assertTrue(userDetailsManager.validateEmail("a@a.com"));
        assertFalse(userDetailsManager.validatePassword("invalidpassword"));
        assertTrue(userDetailsManager.validatePassword("Password123!"));
    }
}
