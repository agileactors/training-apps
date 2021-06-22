package com.agileactors.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agileactors.dao.ContractDao;
import com.agileactors.domain.Contract;
import com.agileactors.dto.contract.CreateContractRequestDto;
import com.agileactors.dto.contract.UpdateContractRequestDto;

@Service
class ContractServiceImpl implements ContractService {

    private final ContractDao contractDao;

    @Autowired
    public ContractServiceImpl(ContractDao contractDao) {
        this.contractDao = contractDao;
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
        contractDao.deleteById(id);
    }

    @Override
    @Transactional
    public Contract create(CreateContractRequestDto createContractRequestDto) {
        var newContract = new Contract();
        newContract.setId(UUID.randomUUID());
        newContract.setName(createContractRequestDto.getName());
        newContract.setContractType(createContractRequestDto.getContractType());
        newContract.setCustomerId(createContractRequestDto.getCustomerId());
        newContract.setCost(createContractRequestDto.getCost());
        newContract.setEngagementDate(createContractRequestDto.getEngagementDate().toInstant());

        if (createContractRequestDto.getDeadlineDate() != null) {
            newContract.setEndDate(createContractRequestDto.getDeadlineDate().toInstant());
        }

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

        return contract;
    }

    @Override
    @Transactional
    public void deleteByCustomerId(UUID customerId) {
        contractDao.deleteByCustomerId(customerId);
    }
}
