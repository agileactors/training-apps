package com.agileactors.dto.audit;

import java.time.ZonedDateTime;
import java.util.UUID;

import com.agileactors.domain.AuditLogType;

public class AuditLogDto {
    private final UUID id;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
    private final AuditLogType auditLogType;
    private final UUID resourceId;

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
}
