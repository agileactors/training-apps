package com.agileactors.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

import com.agileactors.domain.UserRole;
import com.agileactors.domain.UserType;

public abstract class AbstractUserRequestDto {

  @NotBlank(message = "Email is mandatory")
  private final String email;

  @NotBlank(message = "First name is mandatory")
  private final String firstName;

  @NotBlank(message = "Last Name is mandatory")
  private final String lastName;

  @NotNull(message = "Active/Inactive is mandatory")
  private final Boolean active;

  @NotEmpty(message = "Roles[] mandatory")
  private final List<UserRole> roles;

  @NotNull(message = "UserType mandatory")
  private final UserType userType;

  AbstractUserRequestDto(String email, String name, String lastName, boolean active, List<UserRole> roles,
                         UserType userType) {
    this.email = email;
    this.firstName = name;
    this.lastName = lastName;
    this.active = active;
    this.roles = roles;
    this.userType = userType;
  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<UserRole> getRoles() {
    return roles;
  }

  public UserType getUserType() {
    return userType;
  }

  public boolean isActive() {
    return active;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("AbstractUserDto{");
    sb.append("active=").append(active);
    sb.append(", email='").append(email).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", name='").append(firstName).append('\'');
    sb.append(", roles=").append(roles);
    sb.append(", userType=").append(userType);
    sb.append('}');
    return sb.toString();
  }
}
