package com.agileactors.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ContractServiceImpl(ContractDao contractDao, CustomerService customerService, AuditLogService auditLogService) {
        this.contractDao = contractDao;
        this.customerService = customerService;
        this.auditLogService = auditLogService;
    }

    @Override
    @Transactional
    public List<Contract> findAll() {
        return contractDao.findAll();
    }

    @Override
    @Transactional
    public Contract getById(UUID id) {
        return contractDao.getById(id);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.CONTRACT_DELETE, id));
        contractDao.deleteById(id);
    }

    @Override
    @Transactional
    public Contract create(CreateContractRequestDto createContractRequestDto) {
        var newContract = new Contract();
        newContract.setId(UUID.randomUUID());
        newContract.setName(createContractRequestDto.getName());
        newContract.setContractType(createContractRequestDto.getContractType());
        newContract.setCustomer(customerService.getById(createContractRequestDto.getCustomerId()));
        newContract.setCost(createContractRequestDto.getCost());
        newContract.setEngagementDate(createContractRequestDto.getEngagementDate().toInstant());

        if (createContractRequestDto.getDeadlineDate() != null) {
            newContract.setEndDate(createContractRequestDto.getDeadlineDate().toInstant());
        }
        auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.CONTRACT_INIT, newContract.getId()));
        return contractDao.save(newContract);
    }

    @Override
    @Transactional
    public Contract update(UpdateContractRequestDto updateContractRequestDto) {
        var contract = getById(updateContractRequestDto.getId());

        contract.setName(updateContractRequestDto.getName());
        contract.setCost(updateContractRequestDto.getCost());
        contract.setEngagementDate(updateContractRequestDto.getEngagementDate().toInstant());

        if (updateContractRequestDto.getEndDate() != null) {
            contract.setEndDate(updateContractRequestDto.getEndDate().toInstant());
        }

        auditLogService.save(new CreateAuditLogRequestDto(AuditLogType.CONTRACT_UPDATE, contract.getId()));
        return contract;
    }
}
