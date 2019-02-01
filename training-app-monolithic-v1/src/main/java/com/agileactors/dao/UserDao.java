package com.agileactors.dao;

import java.util.UUID;

import com.agileactors.domain.User;

public interface UserDao extends AbstractDao<User, UUID> {
    User findByEmail(String email);
}
