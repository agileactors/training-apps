package com.agileactors.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agileactors.dao.AuditLogDao;
import com.agileactors.domain.AuditLog;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;

@Service
class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogDao auditLogDao;

    @Autowired
    public AuditLogServiceImpl(AuditLogDao auditLogDao) {
        this.auditLogDao = auditLogDao;
    }

    @Override
    @Transactional
    public AuditLog save(CreateAuditLogRequestDto createAuditLogRequestDto) {
        var auditLog = new AuditLog();
        auditLog.setId(UUID.randomUUID());
        auditLog.setAuditLogType(createAuditLogRequestDto.getAuditLogType());
        auditLog.setResourceId(createAuditLogRequestDto.getResourceId());
        return auditLogDao.save(auditLog);
    }

    @Override
    public List<AuditLog> findAll() {
        return auditLogDao.findAll();
    }
}
