package com.foodbank.security;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

        public void configure(WebSecurity web) throws Exception {

            web.ignoring().antMatchers("/img/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.authorizeRequests()
                .antMatchers("/api/contact", "/api/register", "/api/csrf").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").loginProcessingUrl("/api/login").permitAll();
        }
}
