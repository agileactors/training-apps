package com.agileactors.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agileactors.domain.User;
import com.agileactors.dto.user.CreateUserRequestDto;
import com.agileactors.dto.user.UpdateUserRequestDto;
import com.agileactors.dto.user.UserDto;
import com.agileactors.exception.ApplicationException;
import com.agileactors.service.UserService;

@RestController
public class UserApi {

    private final UserService userService;

    private final ConversionService conversionService;

    @Autowired
    public UserApi(UserService userService, ConversionService conversionService) {
        this.userService = userService;
        this.conversionService = conversionService;
    }

    @GetMapping("/users/email/{email}")
    @RolesAllowed("USERS_READ")
    public UserDto findByEmail(@PathVariable String email) {
        var user = userService.findByEmail(email);

        return convert(user);
    }

    @GetMapping("/users/{id}")
    @RolesAllowed("USERS_READ")
    public UserDto findById(@PathVariable UUID id) {
        var user = userService.findById(id);

        return convert(user);
    }

    @GetMapping("/users")
    @RolesAllowed("USERS_READ")
    public List<UserDto> findAll() {
        var users = userService.findAll();

        var results = new ArrayList<UserDto>(users.size());

        users.forEach(user -> results.add(convert(user)));

        return results;
    }

    @PutMapping("/users")
    @RolesAllowed("USERS_WRITE")
    public UserDto update(@RequestBody UpdateUserRequestDto updateUserRequestDto) {
        return convert(userService.update(updateUserRequestDto));
    }

    @PostMapping("/users")
    @RolesAllowed("USERS_WRITE")
    public UserDto create(@RequestBody CreateUserRequestDto createCustomerRequestDto) {
        return convert(userService.create(createCustomerRequestDto));
    }

    @DeleteMapping("/users/{id}")
    @RolesAllowed("USERS_WRITE")
    public void delete(@PathVariable UUID id) throws ApplicationException {
        userService.deleteById(id);
    }

    private UserDto convert(User user) {
        return conversionService.convert(user, UserDto.class);
    }

}
