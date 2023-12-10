package com.agileactors.data.jpa.repository;

import com.agileactors.domain.AuditLog;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends AbstractRepository<AuditLog, UUID> {
}
