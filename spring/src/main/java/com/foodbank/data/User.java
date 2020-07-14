package com.foodbank.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import com.foodbank.data.UserType;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private UserType userType;

    private String email;

    private String passwordHash;

    protected User() {}

    public User(UserType userType, String email, String password) {

        this.userType = userType;
        this.email = email;
        this.passwordHash = hashPassword(password);
    }

    public String hashPassword(String password) {

        return password;
    }
}
