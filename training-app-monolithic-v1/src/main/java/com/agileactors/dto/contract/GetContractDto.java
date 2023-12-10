package com.agileactors.dto.contract;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import com.agileactors.domain.ContractType;
import com.agileactors.dto.customer.GetCustomerDto;

public class GetContractDto implements Serializable {
  private UUID id;
  private String name;
  private ContractType contractType;
  private Instant createdAt;
  private Instant updatedAt;
  private GetCustomerDto customerDto;
  private Long cost;
  private Instant engagementDate;
  private Instant deadlineDate;

  public GetContractDto(UUID id, String name, Instant createdAt, Instant updatedAt,
                        ContractType contractType,
                        GetCustomerDto customerDto, Long cost, Instant engagementDate,
                        Instant deadlineDate) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.contractType = contractType;
    this.customerDto = customerDto;
    this.cost = cost;
    this.engagementDate = engagementDate;
    this.deadlineDate = deadlineDate;

  }

  public Instant getDeadlineDate() {
    return deadlineDate;
  }

  public void setDeadlineDate(Instant deadlineDate) {
    this.deadlineDate = deadlineDate;
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

  public GetCustomerDto getCustomerDto() {
    return customerDto;
  }

  public void setCustomerDto(GetCustomerDto customerDto) {
    this.customerDto = customerDto;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
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

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("ContractDto{");
    sb.append("cost=").append(cost);
    sb.append(", createdAt=").append(createdAt);
    sb.append(", customerDto=").append(customerDto);
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
