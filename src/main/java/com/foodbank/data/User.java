package com.foodbank.data;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.foodbank.data.Authority;

public class User extends org.springframework.security.core.userdetails.User {

    static final long serialVersionUID = 1L;

    @Id
    private String username;

    // private Collection<SimpleGrantedAuthority> authorities;

    public String getEmail() {

        return this.getUsername();
    }
}
