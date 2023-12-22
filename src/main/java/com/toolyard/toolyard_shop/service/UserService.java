package com.toolyard.toolyard_shop.service;

import com.toolyard.toolyard_shop.dto.UserDTO;
import com.toolyard.toolyard_shop.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService { //security
    boolean save(UserDTO userDTO);
    List<UserDTO> getAll();

    User findByName(String name);
    void updateProfile(UserDTO dto);
}
