package com.agileactors.service;

import com.agileactors.dao.AuditLogDao;
import com.agileactors.dao.ContractDao;
import com.agileactors.domain.Contract;
import com.agileactors.dto.audit.AuditLogType;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;
import com.agileactors.dto.contract.CreateContractRequestDto;
import com.agileactors.dto.contract.GetContractDto;
import com.agileactors.dto.contract.UpdateContractRequestDto;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class ContractServiceImpl implements ContractService {

  private final ContractDao contractDao;

  private final AuditLogDao auditLogDao;

  private final ConversionService conversionService;

  @Autowired
  public ContractServiceImpl(ContractDao contractDao,
                             AuditLogDao auditLogDao,
                             ConversionService conversionService) {
    this.contractDao = contractDao;
    this.auditLogDao = auditLogDao;
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
    auditLogDao.create(new CreateAuditLogRequestDto(AuditLogType.CONTRACT_DELETE, id));
    contractDao.deleteById(id);
  }

  @Override
  @Transactional
  public GetContractDto create(CreateContractRequestDto createContractRequestDto) {
    var newContract = new Contract(UUID.randomUUID(),
        createContractRequestDto.name(),
        createContractRequestDto.contractType(),
        createContractRequestDto.cost(), createContractRequestDto.engagementDate(),
        createContractRequestDto.endDate(), createContractRequestDto.customerId());

    auditLogDao.create(
        new CreateAuditLogRequestDto(AuditLogType.CONTRACT_INIT, newContract.getId()));
    return conversionService.convert(contractDao.save(newContract), GetContractDto.class);
  }

  @Override
  @Transactional
  public GetContractDto update(UUID contractId, UpdateContractRequestDto updateContractRequestDto) {
    var contract = contractDao.getById(contractId);

    contract.setName(updateContractRequestDto.name());
    contract.setCost(updateContractRequestDto.cost());
    contract.setEngagementDate(updateContractRequestDto.engagementDate());
    contract.setEndDate(updateContractRequestDto.endDate());

    auditLogDao.create(
        new CreateAuditLogRequestDto(AuditLogType.CONTRACT_UPDATE, contract.getId()));
    return conversionService.convert(contractDao.save(contract), GetContractDto.class);
  }
}
