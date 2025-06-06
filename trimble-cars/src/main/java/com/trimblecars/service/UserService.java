package com.trimblecars.service;

import com.trimblecars.dto.CreateUserRequest;
import com.trimblecars.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(CreateUserRequest request);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
}
