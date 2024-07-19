package com.ntndev.tmdtbasic.services;

import com.ntndev.tmdtbasic.model.User;

public interface UserService {

    User findByUserName(String userName);
}
