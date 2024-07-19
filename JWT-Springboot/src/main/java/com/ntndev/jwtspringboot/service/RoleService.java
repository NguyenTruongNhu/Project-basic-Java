package com.ntndev.jwtspringboot.service;

import com.ntndev.jwtspringboot.entity.ERole;
import com.ntndev.jwtspringboot.entity.Roles;

import java.util.Optional;

public interface RoleService {
    Optional<Roles> findByRoleName(ERole roleName);

}
