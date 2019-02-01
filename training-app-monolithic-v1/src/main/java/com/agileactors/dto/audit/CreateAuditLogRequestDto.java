package com.agileactors.dto.audit;

import java.util.UUID;

import com.agileactors.domain.AuditLogType;

public class CreateAuditLogRequestDto {
    private final AuditLogType auditLogType;
    private final UUID resourceId;

    public CreateAuditLogRequestDto(AuditLogType auditLogType, UUID resourceId) {
        this.auditLogType = auditLogType;
        this.resourceId = resourceId;
    }

    public AuditLogType getAuditLogType() {
        return auditLogType;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CreateAuditLogRequestDto{");
        sb.append("auditLogType=").append(auditLogType);
        sb.append(", resourceId=").append(resourceId);
        sb.append('}');
        return sb.toString();
    }
}
