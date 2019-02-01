package com.agileactors.service;

import java.util.List;
import java.util.UUID;

import com.agileactors.domain.Contract;
import com.agileactors.dto.contract.CreateContractRequestDto;
import com.agileactors.dto.contract.UpdateContractRequestDto;

public interface ContractService {

    List<Contract> findAll();

    Contract getById(UUID id);

    void deleteById(UUID id);

    Contract create(CreateContractRequestDto createContractRequestDto);

    Contract update(UpdateContractRequestDto updateContractRequestDto);

    void deleteByCustomerId(UUID customerId);
}
