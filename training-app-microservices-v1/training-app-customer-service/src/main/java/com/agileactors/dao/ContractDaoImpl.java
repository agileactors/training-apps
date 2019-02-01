package com.agileactors.dao;

import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ContractDaoImpl implements ContractDao {

    @Value("${contract.service.api.url}")
    private URL contractServiceUrl;

    private final RestTemplate customerRestTemplate;

    @Autowired
    public ContractDaoImpl(RestTemplate customerRestTemplate) {
        this.customerRestTemplate = customerRestTemplate;
    }

    @Override
    public void deleteByCustomerId(UUID customerId) {
        customerRestTemplate.delete(contractServiceUrl.toString() + "/contracts/customers/{customerId}", customerId);
    }
}
