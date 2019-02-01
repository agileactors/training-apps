package com.agileactors.dto.user;

import java.util.List;

import com.agileactors.domain.UserRole;
import com.agileactors.domain.UserType;


public class CreateUserRequestDto extends AbstractUserDto {

    private String password;

    public CreateUserRequestDto() {
    }

    public CreateUserRequestDto(String email, String name, String lastName, boolean active, List<UserRole> roles, UserType userType, String password) {
        super(email, name, lastName, active, roles, userType);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CreateUserRequestDto{");
        sb.append("active=").append(isActive());
        sb.append(", email='").append(getEmail()).append('\'');
        sb.append(", lastName='").append(getLastName()).append('\'');
        sb.append(", name='").append(getName()).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", roles=").append(getRoles());
        sb.append(", userType=").append(getUserType());
        sb.append('}');
        return sb.toString();
    }
}
