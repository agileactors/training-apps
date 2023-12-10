package com.agileactors.dto.audit;

import java.time.Instant;
import java.util.UUID;

import com.agileactors.domain.AuditLogType;

public record GetAuditLogDto(UUID id, Instant createdAt, Instant updatedAt,
                             AuditLogType auditLogType, UUID resourceId) {
}
