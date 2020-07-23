package com.foodbank.data.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.stereotype.Repository;

public interface AuthorityRepository extends CrudRepository<SimpleGrantedAuthority, Integer> {

}
