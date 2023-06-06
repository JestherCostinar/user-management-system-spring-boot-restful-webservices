package com.jesthercostinar.springboot.service;

import com.jesthercostinar.springboot.dto.UserDto;
import com.jesthercostinar.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long id);
}
