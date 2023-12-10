package com.agileactors.domain;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

@MappedSuperclass
public abstract class AbstractPersistable<T> implements Serializable {

  @Column(name = "created_at", updatable = false, nullable = false)
  protected Instant createdAt;

  public abstract T getId();

  public Instant getCreatedAt() {
    return createdAt;
  }

  @PrePersist
  public void onPrePersist() {
    // Inject clock instance
    Instant now = Instant.now();
    if (createdAt == null) {
      createdAt = now;
    }
  }

}
