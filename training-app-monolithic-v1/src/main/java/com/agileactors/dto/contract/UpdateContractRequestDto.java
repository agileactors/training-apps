package com.agileactors.dto.contract;

import java.time.ZonedDateTime;
import java.util.UUID;

public class UpdateContractRequestDto {
    private UUID id;
    private String name;
    private Long cost;
    private ZonedDateTime engagementDate;
    private ZonedDateTime endDate;

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
        sb.append(", id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
