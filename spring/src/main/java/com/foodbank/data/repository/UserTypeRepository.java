package com.foodbank.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.foodbank.data.UserType;

public interface UserTypeRepository extends CrudRepository<UserType, Integer> {

    UserType findByName(String name);
}
