package com.foodbank.integration.controllers;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.security.test.context.support.WithMockUser;

import org.springframework.test.web.servlet.MockMvc;

import com.foodbank.controllers.AuthController;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    @Autowired MockMvc mvc;

    @MockBean
    private DataSource dataSource;
    
    @Test
    public void shouldReturnAnonymous() throws Exception {

        mvc.perform(get("/api/auth"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("ROLE_ANONYMOUS")));
    }

    @Test
    @WithMockUser(roles="VOLUNTEER")
    public void shouldReturnVolunteer() throws Exception {

        mvc.perform(get("/api/auth"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("ROLE_VOLUNTEER")));
    }

    @Test
    @WithMockUser(roles="MANAGER")
    public void shouldReturnManager() throws Exception {

        mvc.perform(get("/api/auth"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("ROLE_MANAGER")));
    }
}
