package com.agileactors.dao;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.agileactors.dto.audit.AuditLogDto;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;

@Component
public class AuditLogDaoImpl implements AuditLogDao {

    @Value("${auditlog.service.api.url}")
    private URL auditLogServiceUrl;

    private final RestTemplate auditLogRestTemplate;

    @Autowired
    public AuditLogDaoImpl(RestTemplate auditLogRestTemplate) {
        this.auditLogRestTemplate = auditLogRestTemplate;
    }

    @Override
    public AuditLogDto create(CreateAuditLogRequestDto createAuditLogRequestDto) {
        return auditLogRestTemplate.postForEntity(auditLogServiceUrl.toString() + "/audit-logs", createAuditLogRequestDto, AuditLogDto.class).getBody();
    }
}
