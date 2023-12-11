package com.agileactors.dto.audit;

import java.time.Instant;
import java.util.UUID;

public record GetAuditLogDto(UUID id, Instant createdAt, Instant updatedAt,
                             AuditLogType auditLogType, UUID resourceId) {
}
