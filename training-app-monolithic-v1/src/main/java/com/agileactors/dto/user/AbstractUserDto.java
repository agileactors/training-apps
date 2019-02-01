package com.agileactors.dto.user;

import java.util.List;

import com.agileactors.domain.UserRole;
import com.agileactors.domain.UserType;

public abstract class AbstractUserDto {
    private String email;

    private String name;

    private String lastName;

    private boolean active;

    private List<UserRole> roles;

    private UserType userType;

    AbstractUserDto() {
    }

    AbstractUserDto(String email, String name, String lastName, boolean active, List<UserRole> roles, UserType userType) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.active = active;
        this.roles = roles;
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AbstractUserDto{");
        sb.append("active=").append(active);
        sb.append(", email='").append(email).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", roles=").append(roles);
        sb.append(", userType=").append(userType);
        sb.append('}');
        return sb.toString();
    }
}
