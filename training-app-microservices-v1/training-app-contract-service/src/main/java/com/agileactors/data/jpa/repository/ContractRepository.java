package com.agileactors.data.jpa.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.agileactors.domain.Contract;

@Repository
public interface ContractRepository extends AbstractRepository<Contract, UUID> {
    void deleteByCustomerId(UUID customerId);
}
