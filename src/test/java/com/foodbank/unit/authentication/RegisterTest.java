package com.foodbank.unit;

import com.google.gson.Gson;

import java.util.HashMap;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.context.annotation.Import;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import com.foodbank.GlobalTestConfiguration;
import com.foodbank.controllers.AuthController;
import com.foodbank.security.BasicUserDetailsManager;
import static org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(AuthController.class)
@TestInstance(Lifecycle.PER_CLASS)
@Import(GlobalTestConfiguration.class)
public class RegisterTest {

    @Autowired MockMvc mvc;
    @Autowired DataSource dataSource;

    @MockBean BasicUserDetailsManager userDetailsManager;

    @BeforeAll
    public void setUp() throws Exception {

        when(userDetailsManager.userExists(any(String.class))).thenReturn(true);
    }

    @Test
    public void malformedRequestUnprocessable() throws Exception {

        HashMap<String, String> bodyMap = new HashMap<String, String>();
        bodyMap.put("email", "invalidemail");
        bodyMap.put("password", "invalidpassword");

        String body = new Gson().toJson(bodyMap);

        mvc.perform(post("/api/register")
               .contentType(MediaType.APPLICATION_JSON)
               .content(body)
               .with(csrf()))
            .andExpect(status().isUnprocessableEntity());
    }
}
