package com.agileactors.dto.user;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import com.agileactors.domain.UserRole;
import com.agileactors.domain.UserType;

public class UserDto extends AbstractUserDto {

    private UUID id;

    private ZonedDateTime createdAt;

    private boolean isProtected;

    public UserDto(UUID id, String email, String name, String lastName, boolean active, ZonedDateTime createdAt, List<UserRole> roles, boolean isProtected, UserType userType) {
        super(email, name, lastName, active, roles, userType);
        this.id = id;
        this.createdAt = createdAt;
        this.isProtected = isProtected;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isProtected() {
        return isProtected;
    }

    public void setProtected(boolean isProtected) {
        this.isProtected = isProtected;
    }
}