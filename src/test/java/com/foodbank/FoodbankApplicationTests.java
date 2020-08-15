package com.foodbank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.foodbank.controllers.AuthController;

@SpringBootTest
class FoodbankApplicationTests {

    @Autowired
    private AuthController controller;

	@Test
	void contextLoads() throws Exception {

        assertThat(controller).isNotNull();
	}
}
