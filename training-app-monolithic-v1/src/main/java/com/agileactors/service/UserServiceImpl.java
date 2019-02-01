package com.agileactors.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
class UserServiceImpl implements UserService {

    private final AuditLogService auditLogService;
    private final UserDao userDao;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(AuditLogService auditLogService, UserDao userDao, BCryptPasswordEncoder passwordEncoder) {
        this.auditLogService = auditLogService;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll().stream().filter(user -> !user.getUserType().equals(UserType.SUPER_ADMIN)).collect(Collectors.toList());
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User findById(UUID id) {
        return userDao.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public User create(CreateUserRequestDto createUserRequestDto) {
        var newUser = new User();
        newUser.setId(UUID.randomUUID());
        newUser.setEmail(createUserRequestDto.getEmail());
        newUser.setLastName(createUserRequestDto.getLastName());
        newUser.setName(createUserRequestDto.getName());
        newUser.setPassword(passwordEncoder.encode(createUserRequestDto.getPassword()));
        newUser.setActive(true);
        newUser.setUserType(createUserRequestDto.getUserType());
        newUser.setRoles(createUserRequestDto.getRoles());

        auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.USER_INIT, newUser.getId()));
        return userDao.save(newUser);
    }

    @Override
    @Transactional
    public User update(UpdateUserRequestDto updateUserRequestDto) {
        User user = findById(updateUserRequestDto.getId());

        user.setEmail(updateUserRequestDto.getEmail());
        user.setLastName(updateUserRequestDto.getLastName());
        user.setName(updateUserRequestDto.getName());
        user.setActive(updateUserRequestDto.isActive());
        user.setRoles(updateUserRequestDto.getRoles());
        user.setUserType(updateUserRequestDto.getUserType());

        if (StringUtils.hasText(updateUserRequestDto.getPassword())) {
            user.setPassword(passwordEncoder.encode(updateUserRequestDto.getPassword()));
        }

        auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.USER_UPDATE, user.getId()));
        return user;
    }

    @Override
    @Transactional
    public void deleteById(UUID id) throws ApplicationException {
        User user = findById(id);

        if (user.isProtected()) {
            throw new ApplicationException("Protected accounts can't be deleted");
        }

        auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.USER_DELETE, id));
        userDao.delete(user);
    }

}
