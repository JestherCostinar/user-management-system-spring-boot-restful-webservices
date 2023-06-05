package com.jesthercostinar.springboot.service.impl;

import com.jesthercostinar.springboot.entity.User;
import com.jesthercostinar.springboot.repository.UserRepository;
import com.jesthercostinar.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
}
