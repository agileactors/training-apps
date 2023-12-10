package com.agileactors.service;

import com.agileactors.dao.AuditLogDao;
import com.agileactors.domain.AuditLog;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;
import com.agileactors.dto.audit.GetAuditLogDto;
import java.util.List;
import java.util.UUID;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
class AuditLogServiceImpl implements AuditLogService {

  private final AuditLogDao auditLogDao;
  private final ConversionService conversionService;

  public AuditLogServiceImpl(AuditLogDao auditLogDao, ConversionService conversionService) {
    this.auditLogDao = auditLogDao;
    this.conversionService = conversionService;
  }

  @Override
  @Transactional
  public GetAuditLogDto save(CreateAuditLogRequestDto createAuditLogRequestDto) {
    var auditLog = new AuditLog(UUID.randomUUID(), createAuditLogRequestDto.auditLogType(),
        createAuditLogRequestDto.resourceId());

    return conversionService.convert(auditLogDao.save(auditLog), GetAuditLogDto.class);
  }

  @Override
  public List<GetAuditLogDto> findAll() {
    return auditLogDao.findAll().stream()
        .map(auditLog -> conversionService.convert(auditLog, GetAuditLogDto.class)).toList();
  }
}
