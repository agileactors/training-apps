package com.agileactors.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agileactors.domain.AuditLog;
import com.agileactors.dto.audit.AuditLogDto;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;
import com.agileactors.service.AuditLogService;

@RestController
public class AuditLogApi {

    private final AuditLogService auditLogService;

    private final ConversionService conversionService;

    @Autowired
    public AuditLogApi(AuditLogService auditLogService, ConversionService conversionService) {
        this.auditLogService = auditLogService;
        this.conversionService = conversionService;
    }

    @PostMapping("/audit-logs")
    public AuditLogDto create(@RequestBody CreateAuditLogRequestDto createContractRequestDto) {
        return convert(auditLogService.save(createContractRequestDto));
    }

    @GetMapping("/audit-logs")
    public List<AuditLogDto> findAll() {
        var auditLogs = auditLogService.findAll();

        var results = new ArrayList<AuditLogDto>(auditLogs.size());

        auditLogs.forEach(result -> results.add(convert(result)));

        return results;
    }

    private AuditLogDto convert(AuditLog auditLog) {
        return conversionService.convert(auditLog, AuditLogDto.class);
    }

}
