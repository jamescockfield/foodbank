package com.foodbank.utils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.foodbank.data.User;
import com.foodbank.data.UserType;
import com.foodbank.data.repository.UserRepository;
import com.foodbank.data.repository.UserTypeRepository;

@Configuration
public class DatabaseSeeder {

    
    @Autowired private UserRepository userRepository;
    @Autowired private UserTypeRepository userTypeRepository;

    @Bean
    public CommandLineRunner seed() {
        return args -> {
            
            seedUsers();
        };
    }

    private void seedUsers() {

        userRepository.save(new User(UserType.VOLUNTEER, "user", "password"));
    }

    private void seedUserTypes() {

        userTypeRepository.save(new UserType("Volunteer"));
        userTypeRepository.save(new UserType("Manager"));
    }
}
