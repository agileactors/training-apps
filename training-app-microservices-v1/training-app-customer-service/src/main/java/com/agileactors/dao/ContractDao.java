package com.agileactors.dao;

import java.util.UUID;

public interface ContractDao {
    void deleteByCustomerId(UUID customerId);
}
