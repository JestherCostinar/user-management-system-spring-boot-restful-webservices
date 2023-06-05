package com.jesthercostinar.springboot.controller;

import com.jesthercostinar.springboot.entity.User;
import com.jesthercostinar.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    // Create user REST API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser =userService.create(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
