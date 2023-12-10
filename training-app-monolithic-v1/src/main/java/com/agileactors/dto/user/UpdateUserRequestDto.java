package com.agileactors.dto.user;

import com.agileactors.domain.UserRole;
import com.agileactors.domain.UserType;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

public class UpdateUserRequestDto extends AbstractUserRequestDto {

  @NotBlank(message = "Password is mandatory")
  private final String password;

  public UpdateUserRequestDto(String email, String name, String lastName, boolean active,
                              List<UserRole> roles, UserType userType, UUID id, String password) {
    super(email, name, lastName, active, roles, userType);
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("UpdateUserRequestDto{");
    sb.append("active=").append(isActive());
    sb.append(", email='").append(getEmail()).append('\'');
    sb.append(", lastName='").append(getLastName()).append('\'');
    sb.append(", name='").append(getFirstName()).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", roles=").append(getRoles());
    sb.append(", userType=").append(getUserType());
    sb.append('}');
    return sb.toString();
  }
}
