package com.agileactors.dao;

import java.net.URL;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class ContractDaoImpl implements ContractDao {

  private final URL contractServiceUrl;

  private final RestTemplate contractRestTemplate;

  @Autowired
  public ContractDaoImpl(RestTemplate contractRestTemplate,
                         @Value("${contract.service.api.url}") URL contractServiceUrl) {
    this.contractRestTemplate = contractRestTemplate;
    this.contractServiceUrl = contractServiceUrl;
  }

  @Override
  public void deleteContractsByCustomerId(UUID customerId) {
    contractRestTemplate.delete(contractServiceUrl.toString() + "/contracts/customers/{customerId}",
        customerId);
  }
}
