package com.ntndev.jwtspringboot.repository;

import com.ntndev.jwtspringboot.entity.ERole;
import com.ntndev.jwtspringboot.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByRoleName(ERole roleName);
}
