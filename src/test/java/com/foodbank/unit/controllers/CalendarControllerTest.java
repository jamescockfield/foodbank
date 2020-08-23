package com.foodbank.integration.controllers;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.security.test.context.support.WithMockUser;

import org.springframework.test.web.servlet.MockMvc;

import com.foodbank.controllers.CalendarController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalendarController.class)
public class CalendarControllerTest {

    @Autowired MockMvc mvc;

    @MockBean DataSource dataSource;

    @Test
    @WithMockUser(roles="VOLUNTEER")
    public void respondsNotImplemented() throws Exception {

        mvc.perform(get("/api/calendar"))
            .andExpect(status().isNotImplemented());
    }
}
