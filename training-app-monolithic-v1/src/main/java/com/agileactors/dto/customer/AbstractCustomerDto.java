package com.agileactors.dto.customer;

public abstract class AbstractCustomerDto {
  protected String firstName;

  protected String lastName;

  protected String email;

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

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

}
