package com.foodbank.utils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class DatabaseSeeder {
    
    @Value("${seed}")
    private boolean seed;

    // @Autowired BCryptPasswordEncoder enc;
    // @Autowired JdbcUserDetailsManager userDetailsManager;
    
    @Bean
    public CommandLineRunner seed() {
        return args -> {
            
            if (!seed) {

                return;
            }

            // need to check userdatabase to see if there are any entries instead of true here
            if (false) {

                throw new HibernateException("Database already contains data, please drop the database before attempting to seed");
            }

            seedUsers();

            System.out.println("Done seeding!");
            System.exit(0);
        };
    }

    private void seedUsers() {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        // UserDetails user = new User("user", enc.encode("password"), authorities);
        // userDetailsManager.createUser(user);
        // Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    private void seedUserTypes() {
    }
}
