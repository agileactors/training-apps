package com.agileactors.service;

import com.agileactors.dto.audit.GetAuditLogDto;
import java.util.List;

import com.agileactors.domain.AuditLog;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;

public interface AuditLogService {

  GetAuditLogDto save(CreateAuditLogRequestDto createAuditLogRequestDto);

  List<GetAuditLogDto> findAll();

}
