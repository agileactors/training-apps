package com.agileactors.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class AuditLog extends AbstractUpdatable<UUID> {
  @Id
  @Column(name = "audit_log_id")
  private UUID id;

  @Column(name = "audit_log_type")
  @Enumerated(EnumType.STRING)
  private AuditLogType auditLogType;

  @Column(name = "resource_id")
  private UUID resourceId;

  public AuditLog(UUID id, AuditLogType auditLogType, UUID resourceId) {
    this.id = id;
    this.auditLogType = auditLogType;
    this.resourceId = resourceId;
  }

  protected AuditLog() {
  }

  @Override
  public UUID getId() {
    return id;
  }

  public AuditLogType getAuditLogType() {
    return auditLogType;
  }

  public UUID getResourceId() {
    return resourceId;
  }

}
