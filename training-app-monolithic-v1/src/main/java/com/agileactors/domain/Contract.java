package com.agileactors.domain;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contract extends AbstractUpdatable<UUID> {
  @Id
  @Column(name = "contract_id")
  private UUID id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "contract_type", nullable = false)
  @Enumerated(EnumType.STRING)
  private ContractType contractType;

  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @Column(name = "cost", nullable = false)
  private Long cost;

  @Column(name = "engagement_date", nullable = false)
  private Instant engagementDate;

  @Column(name = "end_date")
  private Instant endDate;

  protected Contract() {
  }

  public Contract(UUID id, String name, ContractType contractType, Customer customer, Long cost,
                  Instant engagementDate, Instant endDate) {
    this.id = id;
    this.name = name;
    this.contractType = contractType;
    this.customer = customer;
    this.cost = cost;
    this.engagementDate = engagementDate;
    this.endDate = endDate;
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

  public Customer getCustomer() {
    return customer;
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

  @Override
  public UUID getId() {
    return id;
  }
}
