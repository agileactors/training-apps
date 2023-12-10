package com.agileactors.api;

import com.agileactors.dto.user.CreateUserRequestDto;
import com.agileactors.dto.user.GetUserDto;
import com.agileactors.dto.user.UpdateUserRequestDto;
import com.agileactors.exception.ApplicationException;
import com.agileactors.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserApi {

  private final UserService userService;

  public UserApi(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/email/{email}")
  @RolesAllowed("USERS_READ")
  public GetUserDto findByEmail(@NotNull @PathVariable String email) {
    return userService.findByEmail(email);
  }

  @GetMapping("/{id}")
  @RolesAllowed("USERS_READ")
  public GetUserDto findById(@NotNull @PathVariable UUID id) {
    return userService.findById(id);
  }

  @GetMapping
  @RolesAllowed("USERS_READ")
  public List<GetUserDto> findAll() {
    return userService.findAll();
  }

  @PutMapping("/{userId}")
  @RolesAllowed("USERS_WRITE")
  public GetUserDto update(@PathVariable UUID userId,
                           @Valid @RequestBody UpdateUserRequestDto updateUserRequestDto) {
    return userService.update(userId, updateUserRequestDto);
  }

  @PostMapping("")
  @RolesAllowed("USERS_WRITE")
  public GetUserDto create(@Valid @RequestBody CreateUserRequestDto createCustomerRequestDto) {
    return userService.create(createCustomerRequestDto);
  }

  @DeleteMapping("/{id}")
  @RolesAllowed("USERS_WRITE")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@NotNull @PathVariable UUID id) throws ApplicationException {
    userService.deleteById(id);
  }
}
