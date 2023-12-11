package com.agileactors.dto.contract;

import com.agileactors.domain.ContractType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.Instant;
import java.util.UUID;

public record CreateContractRequestDto(@NotBlank String name, @NotNull ContractType contractType,
                                       @NotNull UUID customerId, @NotNull @Positive Long cost,
                                       @NotNull @Future Instant engagementDate,
                                       @NotNull @Future Instant endDate) {

  @Override
  public String toString() {
    return "CreateContractRequestDto{" +
        "name='" + name + '\'' +
        ", contractType=" + contractType +
        ", customerId=" + customerId +
        ", cost=" + cost +
        ", engagementDate=" + engagementDate +
        ", deadlineDate=" + endDate +
        '}';
  }
}
