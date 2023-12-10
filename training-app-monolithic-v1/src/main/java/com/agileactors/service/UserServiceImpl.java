package com.agileactors.service;

import com.agileactors.dto.user.GetUserDto;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.agileactors.dao.UserDao;
import com.agileactors.domain.AuditLogType;
import com.agileactors.domain.User;
import com.agileactors.domain.UserType;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;
import com.agileactors.dto.user.CreateUserRequestDto;
import com.agileactors.dto.user.UpdateUserRequestDto;
import com.agileactors.exception.ApplicationException;

@Service
@Transactional(readOnly = true)
class UserServiceImpl implements UserService {

  private final AuditLogService auditLogService;
  private final UserDao userDao;
  private final BCryptPasswordEncoder passwordEncoder;
  private final ConversionService conversionService;

  @Autowired
  public UserServiceImpl(AuditLogService auditLogService, UserDao userDao,
                         BCryptPasswordEncoder passwordEncoder,
                         ConversionService conversionService) {
    this.auditLogService = auditLogService;
    this.userDao = userDao;
    this.passwordEncoder = passwordEncoder;
    this.conversionService = conversionService;
  }

  @Override
  public List<GetUserDto> findAll() {
    return userDao.findAll().stream()
        .filter(user -> !user.getUserType().equals(UserType.SUPER_ADMIN))
        .map(user -> conversionService.convert(user, GetUserDto.class))
        .collect(Collectors.toList());
  }

  @Override
  public GetUserDto findByEmail(String email) {
    return conversionService.convert(userDao.findByEmail(email), GetUserDto.class);
  }

  @Override
  public GetUserDto findById(UUID id) {
    return conversionService.convert(userDao.getById(id), GetUserDto.class);
  }

  @Override
  public GetUserDto create(CreateUserRequestDto createUserRequestDto) {
    var newUser = new User();
    newUser.setId(UUID.randomUUID());
    newUser.setEmail(createUserRequestDto.getEmail());
    newUser.setLastName(createUserRequestDto.getLastName());
    newUser.setName(createUserRequestDto.getFirstName());
    newUser.setPassword(passwordEncoder.encode(createUserRequestDto.getPassword()));
    newUser.setActive(true);
    newUser.setUserType(createUserRequestDto.getUserType());
    newUser.setRoles(createUserRequestDto.getRoles());

    auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.USER_INIT, newUser.getId()));
    return conversionService.convert(userDao.save(newUser), GetUserDto.class);
  }

  @Override
  @Transactional
  public GetUserDto update(UUID userId, UpdateUserRequestDto updateUserRequestDto) {
    User user = userDao.getById(userId);

    user.setEmail(updateUserRequestDto.getEmail());
    user.setLastName(updateUserRequestDto.getLastName());
    user.setName(updateUserRequestDto.getFirstName());
    user.setActive(updateUserRequestDto.isActive());
    user.setRoles(updateUserRequestDto.getRoles());
    user.setUserType(updateUserRequestDto.getUserType());

    if (StringUtils.hasText(updateUserRequestDto.getPassword())) {
      user.setPassword(passwordEncoder.encode(updateUserRequestDto.getPassword()));
    }

    auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.USER_UPDATE, user.getId()));
    return conversionService.convert(user, GetUserDto.class);
  }

  @Override
  @Transactional
  public void deleteById(UUID id) throws ApplicationException {
    GetUserDto user = findById(id);

    if (user.isProtected()) {
      throw new ApplicationException("Protected accounts can't be deleted");
    }

    auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.USER_DELETE, id));
    userDao.deleteById(user.getId());
  }
}
