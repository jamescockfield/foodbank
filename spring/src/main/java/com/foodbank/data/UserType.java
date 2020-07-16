package com.foodbank.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodbank.data.repository.UserTypeRepository;

@Entity
@Data
public class UserType {

    public static final String VOLUNTEER = "Volunteer";
    public static final String MANAGER = "Manager";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    protected UserType() {}

    public UserType(String name) {
        
        this.name = name;
    }
}
