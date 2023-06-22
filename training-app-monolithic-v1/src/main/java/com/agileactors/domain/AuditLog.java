package com.agileactors.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class AuditLog extends AbstractUpdatable<UUID> {
    @Id
    @Column(name = "audit_log_id")
    private UUID id;

    @Column(name = "audit_log_type")
    @Enumerated(EnumType.STRING)
    private AuditLogType auditLogType;

    @Column(name = "resource_id")
    private UUID resourceId;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public AuditLogType getAuditLogType() {
        return auditLogType;
    }

    public void setAuditLogType(AuditLogType auditLogType) {
        this.auditLogType = auditLogType;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public void setResourceId(UUID resourceId) {
        this.resourceId = resourceId;
    }
}
