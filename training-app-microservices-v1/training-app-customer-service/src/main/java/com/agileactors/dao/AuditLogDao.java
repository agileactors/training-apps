package com.agileactors.dao;

import com.agileactors.dto.audit.AuditLogDto;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;

public interface AuditLogDao {
    AuditLogDto create(CreateAuditLogRequestDto createAuditLogRequestDto);
}
