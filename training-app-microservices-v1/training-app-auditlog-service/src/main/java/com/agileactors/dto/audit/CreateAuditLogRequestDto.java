package com.agileactors.dto.audit;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

import com.agileactors.domain.AuditLogType;

public record CreateAuditLogRequestDto(@NotNull AuditLogType auditLogType,
                                       @NotNull UUID resourceId) {
  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("CreateAuditLogRequestDto{");
    sb.append("auditLogType=").append(auditLogType);
    sb.append(", resourceId=").append(resourceId);
    sb.append('}');
    return sb.toString();
  }
}
