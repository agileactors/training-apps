package com.agileactors.service;

import java.util.List;

import com.agileactors.domain.AuditLog;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;

public interface AuditLogService {

    AuditLog save(CreateAuditLogRequestDto createAuditLogRequestDto);

    List<AuditLog> findAll();

}
