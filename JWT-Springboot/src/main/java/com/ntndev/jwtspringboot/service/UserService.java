package com.ntndev.jwtspringboot.service;

import com.ntndev.jwtspringboot.entity.Users;

public interface UserService {
    Users findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
    Users saveOrUpdate(Users user);
}
