package com.jesthercostinar.springboot.service;

import com.jesthercostinar.springboot.entity.User;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);
}
