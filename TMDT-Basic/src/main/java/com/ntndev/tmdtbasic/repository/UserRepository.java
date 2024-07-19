package com.ntndev.tmdtbasic.repository;

import com.ntndev.tmdtbasic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);

}
