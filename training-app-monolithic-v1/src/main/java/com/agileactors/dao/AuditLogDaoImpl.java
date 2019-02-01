package com.agileactors.dao;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.agileactors.data.jpa.repository.AuditLogRepository;
import com.agileactors.domain.AuditLog;

@Component
class AuditLogDaoImpl extends AbstractDaoImpl<AuditLog, UUID, AuditLogRepository> implements AuditLogDao {
    public AuditLogDaoImpl(AuditLogRepository jpaRepository) {
        super(jpaRepository);
    }
}
