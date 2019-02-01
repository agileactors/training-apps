package com.agileactors.data.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.agileactors.domain.User;

@Repository
public interface UserRepository extends AbstractRepository<User, UUID> {
    User findByEmail(String email);
}