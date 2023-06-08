package com.agileactors.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.annotation.security.RolesAllowed;

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

        var contracts = contractService.findAll();

        var results = new ArrayList<ContractDto>(contracts.size());

        contracts.forEach(result -> results.add(convert(result)));

        return results;
    }

    @GetMapping("/contracts/{id}")
    @ResponseBody
    @RolesAllowed("CONTRACTS_READ")
    public ContractDto getById(@PathVariable UUID id) {
        return convert(contractService.getById(id));
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
        contractService.deleteById(id);
    }

    private ContractDto convert(Contract project) {
        return conversionService.convert(project, ContractDto.class);
    }

}
