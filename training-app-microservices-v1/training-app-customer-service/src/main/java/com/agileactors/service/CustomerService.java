package com.agileactors.service;

import com.agileactors.domain.Customer;
import com.agileactors.dto.customer.CreateCustomerRequestDto;
import com.agileactors.dto.customer.GetCustomerDto;
import com.agileactors.dto.customer.UpdateCustomerRequestDto;
import java.util.List;
import java.util.UUID;

public interface CustomerService {

  List<GetCustomerDto> findAll();

  GetCustomerDto getById(UUID id);

  Customer getByIdNative(UUID id);

  GetCustomerDto create(CreateCustomerRequestDto createCustomerRequestDto);

  GetCustomerDto update(UUID customerId, UpdateCustomerRequestDto updateCustomerRequestDto);

  void deleteById(UUID id);
}
