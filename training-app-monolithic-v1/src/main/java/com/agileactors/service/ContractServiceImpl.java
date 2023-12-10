package com.agileactors.service;

import com.agileactors.dto.contract.GetContractDto;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agileactors.dao.ContractDao;
import com.agileactors.domain.AuditLogType;
import com.agileactors.domain.Contract;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;
import com.agileactors.dto.contract.CreateContractRequestDto;
import com.agileactors.dto.contract.UpdateContractRequestDto;

@Service
class ContractServiceImpl implements ContractService {

  private final ContractDao contractDao;

  private final CustomerService customerService;

  private final AuditLogService auditLogService;

  private final ConversionService conversionService;

  @Autowired
  public ContractServiceImpl(ContractDao contractDao,
                             CustomerService customerService,
                             AuditLogService auditLogService,
                             ConversionService conversionService) {
    this.contractDao = contractDao;
    this.customerService = customerService;
    this.auditLogService = auditLogService;
    this.conversionService = conversionService;
  }

  @Override
  public List<GetContractDto> findAll() {
    return contractDao.findAll().stream()
        .map(contract -> conversionService.convert(contract, GetContractDto.class)).toList();
  }

  @Override
  public GetContractDto getById(UUID id) {
    return conversionService.convert(contractDao.getById(id), GetContractDto.class);
  }

  @Override
  @Transactional
  public void deleteById(UUID id) {
    auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.CONTRACT_DELETE, id));
    contractDao.deleteById(id);
  }

  @Override
  @Transactional
  public GetContractDto create(CreateContractRequestDto createContractRequestDto) {
    var newContract = new Contract(UUID.randomUUID(),
        createContractRequestDto.getName(),
        createContractRequestDto.getContractType(),
        customerService.getByIdNative(createContractRequestDto.getCustomerId()),
        createContractRequestDto.getCost(), createContractRequestDto.getEngagementDate(),
        createContractRequestDto.getEndDate());

    auditLogService.save(
        new CreateAuditLogRequestDto(AuditLogType.CONTRACT_INIT, newContract.getId()));
    return conversionService.convert(contractDao.save(newContract), GetContractDto.class);
  }

  @Override
  @Transactional
  public GetContractDto update(UUID contractId, UpdateContractRequestDto updateContractRequestDto) {
    var contract = contractDao.getById(contractId);

    contract.setName(updateContractRequestDto.getName());
    contract.setCost(updateContractRequestDto.getCost());
    contract.setEngagementDate(updateContractRequestDto.getEngagementDate());
    contract.setEndDate(updateContractRequestDto.getEndDate());

    auditLogService.save(
        new CreateAuditLogRequestDto(AuditLogType.CONTRACT_UPDATE, contract.getId()));
    return conversionService.convert(contractDao.save(contract), GetContractDto.class);
  }
}
