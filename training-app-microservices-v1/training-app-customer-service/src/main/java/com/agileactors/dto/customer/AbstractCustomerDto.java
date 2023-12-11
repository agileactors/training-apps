package com.agileactors.dto.customer;

import jakarta.validation.constraints.NotBlank;

public abstract class AbstractCustomerDto {
  @NotBlank
  protected String firstName;

  @NotBlank
  protected String lastName;

  @NotBlank
  protected String email;

  @NotBlank
  protected String address;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return "AbstractCustomerDto{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
