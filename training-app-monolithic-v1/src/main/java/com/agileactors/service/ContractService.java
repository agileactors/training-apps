package com.agileactors.service;

import com.agileactors.dto.contract.GetContractDto;
import java.util.List;
import java.util.UUID;

import com.agileactors.domain.Contract;
import com.agileactors.dto.contract.CreateContractRequestDto;
import com.agileactors.dto.contract.UpdateContractRequestDto;

public interface ContractService {

  List<GetContractDto> findAll();

  GetContractDto getById(UUID id);

  void deleteById(UUID id);

  GetContractDto create(CreateContractRequestDto createContractRequestDto);

  GetContractDto update(UUID contractId, UpdateContractRequestDto updateContractRequestDto);
}
