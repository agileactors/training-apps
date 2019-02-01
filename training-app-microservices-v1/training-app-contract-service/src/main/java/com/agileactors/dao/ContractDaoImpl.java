package com.agileactors.dao;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.agileactors.data.jpa.repository.ContractRepository;
import com.agileactors.domain.Contract;

@Component
class ContractDaoImpl extends AbstractDaoImpl<Contract, UUID, ContractRepository> implements ContractDao {
    public ContractDaoImpl(ContractRepository jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public void deleteByCustomerId(UUID customerId) {
        jpaRepository.deleteByCustomerId(customerId);
    }
}
