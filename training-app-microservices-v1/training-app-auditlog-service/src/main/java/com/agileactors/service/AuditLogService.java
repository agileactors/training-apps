package com.agileactors.service;

import com.agileactors.dto.audit.CreateAuditLogRequestDto;
import com.agileactors.dto.audit.GetAuditLogDto;
import java.util.List;

public interface AuditLogService {

  GetAuditLogDto save(CreateAuditLogRequestDto createAuditLogRequestDto);

  List<GetAuditLogDto> findAll();

}
