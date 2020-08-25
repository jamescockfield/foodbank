package com.foodbank;

import javax.sql.DataSource;

import org.springframework.boot.test.context.TestConfiguration;

import org.springframework.context.annotation.Bean;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

@TestConfiguration
public class GlobalTestConfiguration {

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("foodbank");
        dataSource.setPassword("password");

        return dataSource;
    }
}
