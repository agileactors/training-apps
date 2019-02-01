package com.agileactors.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agileactors.domain.Customer;
import com.agileactors.dto.customer.CreateCustomerRequestDto;
import com.agileactors.dto.customer.CustomerDto;
import com.agileactors.dto.customer.UpdateCustomerRequestDto;
import com.agileactors.service.CustomerService;

@RestController
public class CustomerApi {

    private final CustomerService customerService;

    private final ConversionService conversionService;

    @Autowired
    public CustomerApi(CustomerService customerService, ConversionService conversionService) {
        this.customerService = customerService;
        this.conversionService = conversionService;
    }

    @GetMapping("/customers")
    @RolesAllowed("CUSTOMERS_READ")
    public List<CustomerDto> findAll() {
        List<Customer> customers = customerService.findAll();

        List<CustomerDto> results = new ArrayList<>(customers.size());

        customers.forEach(customer -> results.add(convert(customer)));

        return results;
    }

    @GetMapping("/customers/{id}")
    @RolesAllowed("CUSTOMERS_READ")
    public CustomerDto getById(@PathVariable UUID id) {
        return convert(customerService.getById(id));
    }

    @PostMapping("/customers")
    @RolesAllowed("CUSTOMERS_WRITE")
    public CustomerDto create(@RequestBody CreateCustomerRequestDto createCustomerRequestDto) {
        return convert(customerService.create(createCustomerRequestDto));
    }

    @PutMapping("/customers")
    @RolesAllowed("CUSTOMERS_WRITE")
    public CustomerDto update(@RequestBody UpdateCustomerRequestDto updateCustomerRequestDto) {
        return convert(customerService.update(updateCustomerRequestDto));
    }

    @DeleteMapping("/customers/{id}")
    @RolesAllowed("CUSTOMERS_WRITE")
    public void deleteById(@PathVariable UUID id) {
        customerService.deleteById(id);
    }

    private CustomerDto convert(Customer customer) {
        return conversionService.convert(customer, CustomerDto.class);
    }

}
