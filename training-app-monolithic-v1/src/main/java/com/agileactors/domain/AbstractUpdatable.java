package com.agileactors.domain;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public abstract class AbstractUpdatable<T> extends AbstractPersistable<T> {

    @Column(name = "updated_at")
    protected Instant updatedAt;

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void onPrePersist() {
        super.onPrePersist();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void onPreUpdate() {
        // Inject clock instance
        updatedAt = Instant.now();
    }
}
