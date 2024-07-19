package com.ntndev.jwtspringboot.serviceImpl;

import com.ntndev.jwtspringboot.entity.ERole;
import com.ntndev.jwtspringboot.entity.Roles;
import com.ntndev.jwtspringboot.repository.RoleRepository;
import com.ntndev.jwtspringboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Optional<Roles> findByRoleName(ERole roleName) {

        return roleRepository.findByRoleName(roleName);
    }
}
