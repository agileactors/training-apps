package com.agileactors.dto.contract;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.Instant;

public record UpdateContractRequestDto(@NotBlank String name, @NotNull @Positive Long cost,
                                       @NotNull @Future Instant engagementDate,
                                       @NotNull @Future Instant endDate) {
  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("UpdateContractRequestDto{");
    sb.append("cost=").append(cost);
    sb.append(", engagementDate=").append(engagementDate);
    sb.append(", name='").append(name).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
