package com.foodbank.utils;

import java.util.List;

import org.hibernate.HibernateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.core.JdbcTemplate;

import com.foodbank.data.User;
import com.foodbank.data.UserType;
import com.foodbank.data.repository.UserRepository;
import com.foodbank.data.repository.UserTypeRepository;

@Configuration
public class DatabaseSeeder {
    
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private UserRepository userRepository;
    @Autowired private UserTypeRepository userTypeRepository;

    @Value("${seed}")
    private boolean seed;

    @Bean
    public CommandLineRunner seed() {
        return args -> {
            
            if (!seed) {

                return;
            }

            if (userTypeRepository.count() > 0) {

                throw new HibernateException("Database already contains data, please drop the database before attempting to seed");
            }

            seedUsers();

            System.out.println("Done seeding!");
            System.exit(0);
        };
    }

    private void seedUsers() {

        seedUserTypes();
        UserType userType = userTypeRepository.findByName(UserType.VOLUNTEER);
        userRepository.save(new User(userType, "user", "password"));
    }

    private void seedUserTypes() {

        userTypeRepository.save(new UserType(UserType.VOLUNTEER));
        userTypeRepository.save(new UserType(UserType.MANAGER));
    }
}
