package com.jesthercostinar.springboot.service;

import com.jesthercostinar.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}
