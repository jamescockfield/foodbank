package com.foodbank.data;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodbank.data.repository.UserTypeRepository;

public class UserType {

    public final Integer id;

    public final String name;

    @Autowired
    private UserTypeRepository repository;

    private UserType(String name) {
        
        this.id = repository.findByName(name).id;
        this.name = name;
    }
}
