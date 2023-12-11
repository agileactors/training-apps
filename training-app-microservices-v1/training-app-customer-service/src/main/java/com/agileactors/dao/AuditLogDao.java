package com.agileactors.dao;

import com.agileactors.dto.audit.CreateAuditLogRequestDto;
import com.agileactors.dto.audit.GetAuditLogDto;

public interface AuditLogDao {
  GetAuditLogDto create(CreateAuditLogRequestDto createAuditLogRequestDto);
}
