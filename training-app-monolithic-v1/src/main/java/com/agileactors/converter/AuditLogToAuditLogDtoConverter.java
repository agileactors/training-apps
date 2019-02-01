package com.agileactors.converter;

import java.time.Instant;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.agileactors.date.DateProvider;
import com.agileactors.domain.AuditLog;
import com.agileactors.dto.audit.AuditLogDto;

@Component
public class AuditLogToAuditLogDtoConverter implements Converter<AuditLog, AuditLogDto> {

    private final DateProvider dateProvider;

    @Autowired
    public AuditLogToAuditLogDtoConverter(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    @Override
    public AuditLogDto convert(AuditLog source) {
        return new AuditLogDto(source.getId(), toZonedDateTime(source.getCreatedAt()),
            toZonedDateTime(source.getUpdatedAt()), source.getAuditLogType(), source.getResourceId());
    }

    private ZonedDateTime toZonedDateTime(Instant instant) {
        return dateProvider.toZonedDateTime(instant);
    }
}
