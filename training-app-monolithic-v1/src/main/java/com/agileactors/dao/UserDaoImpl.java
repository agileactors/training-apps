package com.agileactors.dao;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.agileactors.data.jpa.repository.UserRepository;
import com.agileactors.domain.User;

@Component
class UserDaoImpl extends AbstractDaoImpl<User, UUID, UserRepository> implements UserDao {
    public UserDaoImpl(UserRepository jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public User findByEmail(String email) {
        return jpaRepository.findByEmail(email);
    }
}
