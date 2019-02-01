package com.agileactors.data.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.agileactors.domain.AuditLog;

@Repository
public interface AuditLogRepository extends AbstractRepository<AuditLog, UUID> {
}
