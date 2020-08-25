package com.foodbank.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.foodbank.security.JsonUsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private DataSource dataSource;

    private BCryptPasswordEncoder passwordEncoder;

    public SecurityConfig() {

        super();
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Bean
    public BasicUserDetailsManager userDetailsManager() {

        BasicUserDetailsManager manager = new BasicUserDetailsManager();
        manager.setDataSource(dataSource);
        manager.setPasswordEncoder(passwordEncoder);
        return manager;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/img/**");
    }

    private JsonUsernamePasswordAuthenticationFilter jsonAuthenticationFilter() throws Exception {

        JsonUsernamePasswordAuthenticationFilter filter = new JsonUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setFilterProcessesUrl("/api/login");
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
            .antMatchers("/api/contact", "/api/register", "/api/csrf", "/api/auth").permitAll()
            .anyRequest().authenticated().and()
            .addFilterBefore(jsonAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
            .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/api/login")
                .successForwardUrl("/")
                .permitAll().and()
            .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/");
    }

}
