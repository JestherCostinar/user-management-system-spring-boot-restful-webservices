package com.jesthercostinar.springboot.service.impl;

import com.jesthercostinar.springboot.dto.UserDto;
import com.jesthercostinar.springboot.entity.User;
import com.jesthercostinar.springboot.mapper.AutoUserMapper;
import com.jesthercostinar.springboot.mapper.UserMapper;
import com.jesthercostinar.springboot.repository.UserRepository;
import com.jesthercostinar.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert UserDto into user JPA Entity
//        User user = UserMapper.mapToUser(userDto);
//        User user = modelMapper.map(userDto, User.class);
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);

        // Will save the user (DTO entity type) to table and store the value in savedUser
        User savedUser = userRepository.save(user);

        //This will convert User JPA entity(from saveUser variable) to UserDto type
        //UserDto saveUserDto = UserMapper.mapToUserDto(savedUser);
//        UserDto saveUserDto = modelMapper.map(savedUser, UserDto.class);
        UserDto saveUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);

        return saveUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();

//        return UserMapper.mapToUserDto(user);
//        return modelMapper.map(user, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(optionalUser.get());

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

//        return users.stream()
//                .map(UserMapper::mapToUserDto)
//                .collect(Collectors.toList());

//        return users.stream()
//                .map((user) -> modelMapper.map(user, UserDto.class))
//                .collect(Collectors.toList());

        return users.stream()
                .map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updateUser = userRepository.save(existingUser);
//        return UserMapper.mapToUserDto(updateUser);
//        return modelMapper.map(updateUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updateUser);

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
