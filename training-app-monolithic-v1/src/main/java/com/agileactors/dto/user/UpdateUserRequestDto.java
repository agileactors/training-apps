package com.agileactors.dto.user;

import java.util.List;
import java.util.UUID;

import com.agileactors.domain.UserRole;
import com.agileactors.domain.UserType;

public class UpdateUserRequestDto extends AbstractUserDto {

    private UUID id;

    private String password;

    public UpdateUserRequestDto() {
    }

    public UpdateUserRequestDto(String email, String name, String lastName, boolean active, List<UserRole> roles, UserType userType, UUID id, String password) {
        super(email, name, lastName, active, roles, userType);
        this.id = id;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UpdateUserRequestDto{");
        sb.append("active=").append(isActive());
        sb.append(", email='").append(getEmail()).append('\'');
        sb.append(", id=").append(id);
        sb.append(", lastName='").append(getLastName()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", roles=").append(getRoles());
        sb.append(", userType=").append(getUserType());
        sb.append('}');
        return sb.toString();
    }
}