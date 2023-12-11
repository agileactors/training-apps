package com.agileactors.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
public class Contract extends AbstractUpdatable<UUID> {
  @Id
  @Column(name = "contract_id")
  private UUID id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Enumerated(EnumType.STRING)
  private ContractType contractType;

  private Long cost;

  private Instant engagementDate;

  private Instant endDate;

  private UUID customerId;

  protected Contract() {
  }

  public Contract(UUID id, String name, ContractType contractType, Long cost,
                  Instant engagementDate, Instant endDate, UUID customerId) {
    this.id = id;
    this.name = name;
    this.contractType = contractType;
    this.cost = cost;
    this.engagementDate = engagementDate;
    this.endDate = endDate;
    this.customerId = customerId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setContractType(ContractType contractType) {
    this.contractType = contractType;
  }

  public void setCost(Long cost) {
    this.cost = cost;
  }

  public void setEngagementDate(Instant engagementDate) {
    this.engagementDate = engagementDate;
  }

  public void setEndDate(Instant endDate) {
    this.endDate = endDate;
  }

  public ContractType getContractType() {
    return contractType;
  }

  public String getName() {
    return name;
  }

  public Long getCost() {
    return cost;
  }

  public Instant getEngagementDate() {
    return engagementDate;
  }

  public Instant getEndDate() {
    return endDate;
  }

  public UUID getCustomerId() {
    return customerId;
  }

  @Override
  public UUID getId() {
    return id;
  }
}
