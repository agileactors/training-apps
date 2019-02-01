package com.agileactors.service;

import java.util.List;
import java.util.UUID;

import com.agileactors.domain.Customer;
import com.agileactors.dto.customer.CreateCustomerRequestDto;
import com.agileactors.dto.customer.UpdateCustomerRequestDto;

public interface CustomerService {

    List<Customer> findAll();

    Customer getById(UUID id);

    Customer create(CreateCustomerRequestDto createCustomerRequestDto);

    Customer update(UpdateCustomerRequestDto updateCustomerRequestDto);

    void deleteById(UUID id);
}
