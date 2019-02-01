package com.agileactors.dao;

import java.util.UUID;

import com.agileactors.domain.Contract;

public interface ContractDao extends AbstractDao<Contract, UUID> {
    void deleteByCustomerId(UUID customerId);
}
