package com.agileactors.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agileactors.domain.Contract;
import com.agileactors.dto.contract.GetContractDto;
import com.agileactors.dto.contract.CreateContractRequestDto;
import com.agileactors.dto.contract.UpdateContractRequestDto;
import com.agileactors.service.ContractService;

@RestController
@RequestMapping("/contracts")
class ContractApi {

  private final ContractService contractService;

  public ContractApi(ContractService contractService) {
    this.contractService = contractService;
  }

  @GetMapping
  @ResponseBody
  @RolesAllowed("CONTRACTS_READ")
  public List<GetContractDto> findAll() {
    return contractService.findAll();
  }

  @GetMapping("{id}")
  @ResponseBody
  @RolesAllowed("CONTRACTS_READ")
  public GetContractDto getById(@PathVariable UUID id) {
    return contractService.getById(id);
  }

  @PostMapping
  @RolesAllowed("CONTRACTS_WRITE")
  public GetContractDto create(@RequestBody CreateContractRequestDto createContractRequestDto) {
    return contractService.create(createContractRequestDto);
  }

  @PutMapping("/{contractId}")
  @RolesAllowed("CONTRACTS_WRITE")
  public GetContractDto update(@PathVariable UUID contractId,
                               @RequestBody UpdateContractRequestDto updateContractRequestDto) {
    return contractService.update(contractId, updateContractRequestDto);
  }

  @DeleteMapping("{id}")
  @RolesAllowed("CONTRACTS_WRITE")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    contractService.deleteById(id);
  }

}
