package com.agileactors.dto.contract;

import com.agileactors.domain.ContractType;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public record GetContractDto(UUID id, String name, Instant createdAt, Instant updatedAt,
                             ContractType contractType, Long cost, Instant engagementDate,
                             Instant deadlineDate) implements Serializable {

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("ContractDto{");
    sb.append("cost=").append(cost);
    sb.append(", createdAt=").append(createdAt);
    sb.append(", deadlineDate=").append(deadlineDate);
    sb.append(", engagementDate=").append(engagementDate);
    sb.append(", id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", contractType='").append(contractType).append('\'');
    sb.append(", updatedAt=").append(updatedAt);
    sb.append('}');
    return sb.toString();
  }
}
