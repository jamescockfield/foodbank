package com.foodbank.integration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class SecurityBasicTest {
 
    TestRestTemplate restTemplate;
    URL base;
    @LocalServerPort int port;
 
    @BeforeAll
    public void setUp() throws MalformedURLException {
        
        restTemplate = new TestRestTemplate("manager", "password");
        base = new URL("http://localhost:" + port + "/api/auth");
    }
 
    @Test
    public void whenLoggedManager_thenRoleManager() throws IllegalStateException, IOException {

        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("ROLE_MANAGER"));
    }
 
    @Test
    public void whenUserWithWrongCredentials_thenStillAnonymous() throws Exception {
 
        restTemplate = new TestRestTemplate("manager", "wrongpassword");
        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("ROLE_ANONYMOUS"));
    }
}
