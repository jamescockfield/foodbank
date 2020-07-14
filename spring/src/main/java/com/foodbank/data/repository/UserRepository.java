package com.foodbank.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.foodbank.data.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
