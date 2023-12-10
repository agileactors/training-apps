package com.agileactors.service;

import com.agileactors.dto.user.GetUserDto;
import java.util.List;
import java.util.UUID;

import com.agileactors.domain.User;
import com.agileactors.dto.user.CreateUserRequestDto;
import com.agileactors.dto.user.UpdateUserRequestDto;
import com.agileactors.exception.ApplicationException;

public interface UserService {

  List<GetUserDto> findAll();

  GetUserDto findByEmail(String email);

  GetUserDto create(CreateUserRequestDto createUserRequestDto);

  GetUserDto update(UUID userId, UpdateUserRequestDto updateUserRequestDto);

  GetUserDto findById(UUID id);

  void deleteById(UUID id) throws ApplicationException;
}
