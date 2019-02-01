package com.agileactors.dto.customer;

import java.util.UUID;

public class UpdateCustomerRequestDto extends AbstractCustomerDto {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
