package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Employee;
import com.simplestocking.demo.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    Users create(Users users);
    List<Users> findAll();
    Optional<Users> findById(String id);

}
