package com.agileactors.dto.contract;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

import com.agileactors.domain.ContractType;

public class ContractDto implements Serializable {
    private UUID id;
    private String name;
    private ContractType contractType;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private UUID customerId;
    private Long cost;
    private ZonedDateTime engagementDate;
    private ZonedDateTime deadlineDate;

    public ContractDto(UUID id, String name, ZonedDateTime createdAt, ZonedDateTime updatedAt, ContractType contractType,
                       UUID customerId, Long cost, ZonedDateTime engagementDate,
                       ZonedDateTime deadlineDate) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.contractType = contractType;
        this.customerId = customerId;
        this.cost = cost;
        this.engagementDate = engagementDate;
        this.deadlineDate = deadlineDate;

    }

    public ZonedDateTime getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(ZonedDateTime deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public ZonedDateTime getEngagementDate() {
        return engagementDate;
    }

    public void setEngagementDate(ZonedDateTime engagementDate) {
        this.engagementDate = engagementDate;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
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
        sb.append(", customerId=").append(customerId);
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
