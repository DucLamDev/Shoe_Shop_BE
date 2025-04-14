package com.example.shop_giay.service;

import com.example.shop_giay.dto.LoginRequest;
import com.example.shop_giay.dto.RegisterRequest;
import com.example.shop_giay.dto.UserDTO;
import com.example.shop_giay.entity.User;

public interface UserService {
    UserDTO register(RegisterRequest request);
    String login(LoginRequest request);
    UserDTO getCurrentUser();
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(Long id);
} 