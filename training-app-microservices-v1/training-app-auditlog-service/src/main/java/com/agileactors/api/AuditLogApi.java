package com.agileactors.api;

import com.agileactors.dto.audit.CreateAuditLogRequestDto;
import com.agileactors.dto.audit.GetAuditLogDto;
import com.agileactors.service.AuditLogService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audit-logs")
class AuditLogApi {

  private final AuditLogService auditLogService;

  public AuditLogApi(AuditLogService auditLogService) {
    this.auditLogService = auditLogService;
  }

  @PostMapping
  public GetAuditLogDto create(
      @Valid @RequestBody CreateAuditLogRequestDto createContractRequestDto) {
    return auditLogService.save(createContractRequestDto);
  }

  @GetMapping
  public List<GetAuditLogDto> findAll() {
    return auditLogService.findAll();
  }

}
