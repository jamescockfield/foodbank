package com.foodbank.integration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SecurityBasicIT {
 
    URL base;
    @LocalServerPort int port;

    @Autowired
    private TestRestTemplate restTemplate;
 
    @BeforeAll
    public void setUp() throws MalformedURLException {
        
        base = new URL("http://localhost:" + port + "/api/auth");
    }
 
    @Test
    public void authShouldReturnAnonymous() throws Exception {

        assertThat(restTemplate.getForObject(base.toString(), String.class)).contains("ROLE_ANONYMOUS");
    }

    @Test
    public void whenLoggedManager_thenRoleManager() throws IllegalStateException, IOException {

        restTemplate = new TestRestTemplate("manager", "password");
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
