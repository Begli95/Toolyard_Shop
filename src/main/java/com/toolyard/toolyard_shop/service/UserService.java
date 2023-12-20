package com.toolyard.toolyard_shop.service;

import com.toolyard.toolyard_shop.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService { //security
    boolean save(UserDTO userDTO);
}
