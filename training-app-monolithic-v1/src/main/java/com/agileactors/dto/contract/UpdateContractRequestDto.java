package com.agileactors.dto.contract;

import java.time.Instant;
import java.util.UUID;

public class UpdateContractRequestDto {
  private String name;
  private Long cost;
  private Instant engagementDate;
  private Instant endDate;

  public Instant getEndDate() {
    return endDate;
  }

  public void setEndDate(Instant endDate) {
    this.endDate = endDate;
  }

  public Instant getEngagementDate() {
    return engagementDate;
  }

  public void setEngagementDate(Instant engagementDate) {
    this.engagementDate = engagementDate;
  }

  public Long getCost() {
    return cost;
  }

  public void setCost(Long cost) {
    this.cost = cost;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

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
