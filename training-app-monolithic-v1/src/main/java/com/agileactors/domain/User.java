package com.agileactors.domain;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class User extends AbstractUpdatable<UUID> implements Comparable<User> {

    @Id
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "active")
    private boolean active;

    @Column(name = "protected")
    private boolean isProtected;

    @Column(name = "roles")
    @Type(type = "com.agileactors.domain.StringArrayType")
    private String[] roles;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public List<UserRole> getRoles() {
        return Stream.of(roles).map(UserRole::valueOf).collect(Collectors.toList());
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles.stream().map(UserRole::name).collect(Collectors.toList()).toArray(String[]::new);
    }

    public boolean isProtected() {
        return isProtected;
    }

    public void setProtected(boolean isProtected) {
        this.isProtected = isProtected;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public int compareTo(User o) {
        return o.createdAt.compareTo(this.createdAt);
    }
}