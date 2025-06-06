package com.trimblecars.dto;

import com.trimblecars.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email must be valid")
    //@NotBlank(message = "Email is required")
    private String email;

    //@NotNull(message = "Role is required")
    private Role role;
}


