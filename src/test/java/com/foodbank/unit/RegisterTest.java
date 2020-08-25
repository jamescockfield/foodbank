package com.foodbank.unit.authentication;

import com.google.gson.Gson;

import java.util.HashMap;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.context.annotation.Import;

import org.springframework.http.MediaType;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.foodbank.GlobalTestConfiguration;
import com.foodbank.controllers.AuthController;
import com.foodbank.security.BasicUserDetailsManager;
import static org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(AuthController.class)
@TestInstance(Lifecycle.PER_CLASS)
@Import(GlobalTestConfiguration.class)
public class RegisterTest {

    @Autowired MockMvc mvc;
    @Autowired DataSource dataSource;

    @MockBean BasicUserDetailsManager userDetailsManager;
    @MockBean UserDetails userDetails;

    private MockHttpServletRequestBuilder request;

    @BeforeAll
    public void setUp() throws Exception {

        HashMap<String, String> bodyMap = new HashMap<String, String>();
        bodyMap.put("email", "a@a.com");
        bodyMap.put("password", "Password123!");
        bodyMap.put("role", "Manager");

        String body = new Gson().toJson(bodyMap);

        request = post("/api/register")
            .contentType(MediaType.APPLICATION_JSON)
            .with(csrf())
            .content(body);
    }

    @Test
    public void malformedRequestUnprocessable() throws Exception {

        MockHttpServletRequestBuilder malformedRequest = post("/api/register")
            .contentType(MediaType.APPLICATION_JSON)
            .with(csrf())
            .content("{\"name\": \"invalid_JSON\"}");

        mvc.perform(malformedRequest)
            .andExpect(status().isUnprocessableEntity())
            .andExpect(content().string("Invalid request"));
    }

    @Test
    public void invalidEmailUnprocessable() throws Exception {

        when(userDetailsManager.validateEmail(any(String.class))).thenReturn(false);
        mvc.perform(request)
            .andExpect(status().isUnprocessableEntity())
            .andExpect(content().string("Invalid email"));
    }

    @Test
    public void invalidPasswordUnprocessable() throws Exception {

        when(userDetailsManager.validatePassword(any(String.class))).thenReturn(false);
        mvc.perform(request)
            .andExpect(status().isUnprocessableEntity())
            .andExpect(content().string("Invalid password"));
    }

    @Test
    public void emailAlreadyExistsConflict() throws Exception {

        when(userDetailsManager.userExists(any(String.class))).thenReturn(true);
        mvc.perform(request)
            .andExpect(status().isUnprocessableEntity())
            .andExpect(content().string("Invalid password"));
    }

    @Test
    public void newUserEnabledSuccess() throws Exception {

        when(userDetails.isEnabled()).thenReturn(true);
        mvc.perform(request)
            .andExpect(status().isOk());
    }
}
