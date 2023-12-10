package com.agileactors.api;

import com.agileactors.dto.customer.CreateCustomerRequestDto;
import com.agileactors.dto.customer.GetCustomerDto;
import com.agileactors.dto.customer.UpdateCustomerRequestDto;
import com.agileactors.service.CustomerService;
import jakarta.annotation.security.RolesAllowed;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
class CustomerApi {

  private final CustomerService customerService;

  public CustomerApi(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  @RolesAllowed("CUSTOMERS_READ")
  public List<GetCustomerDto> findAll() {
    return customerService.findAll();
  }

  @GetMapping("/{id}")
  @RolesAllowed("CUSTOMERS_READ")
  public GetCustomerDto getById(@PathVariable UUID id) {
    return customerService.getById(id);
  }

  @PostMapping("")
  @RolesAllowed("CUSTOMERS_WRITE")
  public GetCustomerDto create(@RequestBody CreateCustomerRequestDto createCustomerRequestDto) {
    return customerService.create(createCustomerRequestDto);
  }

  @PutMapping("{customerId}")
  @RolesAllowed("CUSTOMERS_WRITE")
  public GetCustomerDto update(@PathVariable UUID customerId,
                               @RequestBody UpdateCustomerRequestDto updateCustomerRequestDto) {
    return customerService.update(customerId, updateCustomerRequestDto);
  }

  @DeleteMapping("/{id}")
  @RolesAllowed("CUSTOMERS_WRITE")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable UUID id) {
    customerService.deleteById(id);
  }
}
