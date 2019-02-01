package com.agileactors.dto.customer;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import com.agileactors.dto.contract.ContractDto;

public class CustomerDto extends AbstractCustomerDto implements Serializable {
    private final UUID id;

    private final List<ContractDto> contracts;

    private final ZonedDateTime createdAt;

    private String address;

    public CustomerDto(UUID id, String companyName, String contactName, String contactEmail,
                       List<ContractDto> contracts, ZonedDateTime createdAt, String address) {
        this.id = id;
        this.firstName = companyName;
        this.email = contactEmail;
        this.lastName = contactName;
        this.contracts = contracts;
        this.createdAt = createdAt;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public UUID getId() {
        return id;
    }

    public List<ContractDto> getContracts() {
        return contracts;
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
                ", contracts=%s" +
                "}",
            address, firstName, firstName, email, email,
            lastName, lastName, createdAt, id, contracts
        );
    }
}
