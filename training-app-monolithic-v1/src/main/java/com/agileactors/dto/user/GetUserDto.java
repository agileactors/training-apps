package com.agileactors.dto.user;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.agileactors.domain.UserRole;
import com.agileactors.domain.UserType;

public class GetUserDto extends AbstractUserRequestDto {

  private final UUID id;

  private final Instant createdAt;

  private final boolean isProtected;

  public GetUserDto(UUID id, String email, String name, String lastName, boolean active,
                    Instant createdAt, List<UserRole> roles, boolean isProtected,
                    UserType userType) {
    super(email, name, lastName, active, roles, userType);
    this.id = id;
    this.createdAt = createdAt;
    this.isProtected = isProtected;
  }

  public UUID getId() {
    return id;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public boolean isProtected() {
    return isProtected;
  }

}
