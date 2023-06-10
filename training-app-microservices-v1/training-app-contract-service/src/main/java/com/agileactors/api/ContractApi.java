package com.agileactors.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.agileactors.domain.Contract;
import com.agileactors.dto.contract.ContractDto;
import com.agileactors.dto.contract.CreateContractRequestDto;
import com.agileactors.dto.contract.UpdateContractRequestDto;
import com.agileactors.service.ContractService;

@RestController
public class ContractApi {

    private static Logger LOGGER = LoggerFactory.getLogger(ContractApi.class);

    private final ContractService contractService;

    private final ConversionService conversionService;

    @Autowired
    public ContractApi(ContractService contractService, ConversionService conversionService) {
        this.contractService = contractService;
        this.conversionService = conversionService;
    }

    @GetMapping("/contracts")
    @ResponseBody
    @RolesAllowed("CONTRACTS_READ")
    public List<ContractDto> findAll() {

        LOGGER.info("ContractApi.findAll() - Start");

        var contracts = contractService.findAll();

        var results = new ArrayList<ContractDto>(contracts.size());

        contracts.forEach(result -> results.add(convert(result)));

        LOGGER.info("ContractApi.findAll() - End");

        return results;
    }

    @GetMapping("/contracts/{id}")
    @ResponseBody
    @RolesAllowed("CONTRACTS_READ")
    public ContractDto getById(@PathVariable UUID id) {
        LOGGER.info("ContractApi.getById({}) - Start", id);

        var result = convert(contractService.getById(id));

        LOGGER.info("ContractApi.getById({}) - End", id);

        return result;
    }

    @PostMapping("/contracts")
    @RolesAllowed("CONTRACTS_WRITE")
    public ContractDto create(@RequestBody CreateContractRequestDto createContractRequestDto) {
        return convert(contractService.create(createContractRequestDto));
    }

    @PutMapping("/contracts")
    @RolesAllowed("CONTRACTS_WRITE")
    public ContractDto update(@RequestBody UpdateContractRequestDto updateContractRequestDto) {
        return convert(contractService.update(updateContractRequestDto));
    }

    @DeleteMapping("/contracts/{id}")
    @RolesAllowed("CONTRACTS_WRITE")
    public void delete(@PathVariable UUID id) {
        LOGGER.info("ContractApi.delete({}) - Start", id);
        contractService.deleteById(id);
        LOGGER.info("ContractApi.delete({}) - End", id);
    }

    @DeleteMapping("/contracts/customers/{customerId}")
    @RolesAllowed("CONTRACTS_WRITE")
    public void deleteByCustomerId(@PathVariable UUID customerId) {
        LOGGER.info("ContractApi.deleteByCustomerId({}) - Start", customerId);
        contractService.deleteByCustomerId(customerId);
        LOGGER.info("ContractApi.deleteByCustomerId({}) - End", customerId);
    }

    private ContractDto convert(Contract project) {
        return conversionService.convert(project, ContractDto.class);
    }

}
