package com.jesthercostinar.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private Long id;
    @NotEmpty(message = "User firstName should not be empty")
    private String firstName;
    @NotEmpty(message = "User lastName should not be empty")
    private String lastName;

    @NotEmpty(message = "User email should not be empty")
    @Email(message = "Invalid email address")
    private String email;
}
