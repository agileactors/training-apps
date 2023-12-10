package com.agileactors.dto.contract;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.agileactors.domain.ContractType;

public class CreateContractRequestDto {
  private String name;
  private ContractType contractType;
  private UUID customerId;
  private Long cost;
  private Instant engagementDate;
  private Instant deadlineDate;

  private List<UUID> userIds;

  public List<UUID> getUserIds() {
    return userIds;
  }

  public Instant getEndDate() {
    return deadlineDate;
  }

  public void setDeadlineDate(Instant deadlineDate) {
    this.deadlineDate = deadlineDate;
  }

  public void setUserIds(List<UUID> userIds) {
    this.userIds = userIds;
  }

  public UUID getCustomerId() {
    return customerId;
  }

  public void setCustomerId(UUID customerId) {
    this.customerId = customerId;
  }

  public ContractType getContractType() {
    return contractType;
  }

  public void setContractType(ContractType contractType) {
    this.contractType = contractType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getCost() {
    return cost;
  }

  public void setCost(Long cost) {
    this.cost = cost;
  }

  public Instant getEngagementDate() {
    return engagementDate;
  }

  public void setEngagementDate(Instant engagementDate) {
    this.engagementDate = engagementDate;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("CreateContractRequestDto{");
    sb.append("cost=").append(cost);
    sb.append(", customerId=").append(customerId);
    sb.append(", deadlineDate=").append(deadlineDate);
    sb.append(", engagementDate=").append(engagementDate);
    sb.append(", name='").append(name).append('\'');
    sb.append(", contractType='").append(contractType).append('\'');
    sb.append(", userIds=").append(userIds);
    sb.append('}');
    return sb.toString();
  }
}
