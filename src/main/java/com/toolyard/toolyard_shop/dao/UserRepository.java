package com.toolyard.toolyard_shop.dao;


import com.toolyard.toolyard_shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByName(String name);
}
