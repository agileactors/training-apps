package com.agileactors.domain;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer extends AbstractUpdatable<UUID> {
  @Id
  @Column(name = "customer_id")
  private UUID id;

  @Column(name = "first_name", nullable = false, unique = true)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "address", nullable = false)
  private String address;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Contract> contracts;

  protected Customer() {
  }

  public Customer(UUID id, String firstName, String lastName, String email, String address,
                  List<Contract> contracts) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
    this.contracts = contracts;
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

  public List<Contract> getContracts() {
    return contracts;
  }

  public void setContracts(List<Contract> contracts) {
    this.contracts = contracts;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public UUID getId() {
    return id;
  }
}
