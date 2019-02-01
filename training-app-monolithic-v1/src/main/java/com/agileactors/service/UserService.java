package com.agileactors.service;

import java.util.List;
import java.util.UUID;

import com.agileactors.domain.User;
import com.agileactors.dto.user.CreateUserRequestDto;
import com.agileactors.dto.user.UpdateUserRequestDto;
import com.agileactors.exception.ApplicationException;

public interface UserService {

    List<User> findAll();

    User findByEmail(String email);

    User create(CreateUserRequestDto createUserRequestDto);

    User update(UpdateUserRequestDto updateUserRequestDto);

    User findById(UUID id);

    void deleteById(UUID id) throws ApplicationException;
}