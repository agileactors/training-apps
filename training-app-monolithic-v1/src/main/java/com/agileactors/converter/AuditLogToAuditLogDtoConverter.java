package com.agileactors.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.agileactors.domain.AuditLog;
import com.agileactors.dto.audit.GetAuditLogDto;

@Component
public class AuditLogToAuditLogDtoConverter implements Converter<AuditLog, GetAuditLogDto> {

  @Override
  public GetAuditLogDto convert(AuditLog source) {
    return new GetAuditLogDto(source.getId(), source.getUpdatedAt(), source.getUpdatedAt(),
        source.getAuditLogType(), source.getResourceId());
  }
}
