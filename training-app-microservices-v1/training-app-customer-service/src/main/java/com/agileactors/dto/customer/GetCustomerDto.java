package com.agileactors.dto.customer;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class GetCustomerDto extends AbstractCustomerDto implements Serializable {
  private final UUID id;

  private final Instant createdAt;

  private final String address;

  public GetCustomerDto(UUID id, String companyName, String contactName, String contactEmail,
                        Instant createdAt, String address) {
    this.id = id;
    this.firstName = companyName;
    this.email = contactEmail;
    this.lastName = contactName;
    this.createdAt = createdAt;
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public UUID getId() {
    return id;
  }

  @Override
  public String toString() {
    return String.format("CustomerDto{" +
            "address=%s" +
            ", firstName=%s" +
            ", firstName=%s" +
            ", email=%s" +
            ", email=%s" +
            ", lastName=%s" +
            ", lastName=%s" +
            ", createdAt=%s" +
            ", id=%s" +
            "}",
        address, firstName, firstName, email, email,
        lastName, lastName, createdAt, id
    );
  }
}
