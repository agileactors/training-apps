package com.agileactors.dto.audit;

import java.util.UUID;

import com.agileactors.domain.AuditLogType;

public record CreateAuditLogRequestDto(AuditLogType auditLogType, UUID resourceId) {
  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("CreateAuditLogRequestDto{");
    sb.append("auditLogType=").append(auditLogType);
    sb.append(", resourceId=").append(resourceId);
    sb.append('}');
    return sb.toString();
  }
}
