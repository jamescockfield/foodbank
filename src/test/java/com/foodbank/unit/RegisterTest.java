package com.foodbank.unit;

import com.google.gson.Gson;

import java.util.HashMap;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import com.foodbank.controllers.AuthController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;


@WebMvcTest(AuthController.class)
public class RegisterTest {

    @Autowired MockMvc mvc;

    @MockBean DataSource dataSource;

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
