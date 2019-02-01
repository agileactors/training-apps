package com.agileactors.dto.audit;

import java.time.ZonedDateTime;
import java.util.UUID;

public class AuditLogDto {
    private UUID id;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private AuditLogType auditLogType;
    private UUID resourceId;

    public AuditLogDto() {
    }

    public AuditLogDto(UUID id, ZonedDateTime createdAt, ZonedDateTime updatedAt, AuditLogType auditLogType, UUID resourceId) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.auditLogType = auditLogType;
        this.resourceId = resourceId;
    }

    public UUID getId() {
        return id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public AuditLogType getAuditLogType() {
        return auditLogType;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setAuditLogType(AuditLogType auditLogType) {
        this.auditLogType = auditLogType;
    }

    public void setResourceId(UUID resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AuditLogDto{");
        sb.append("auditLogType=").append(auditLogType);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", id=").append(id);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append('}');
        return sb.toString();
    }
}
