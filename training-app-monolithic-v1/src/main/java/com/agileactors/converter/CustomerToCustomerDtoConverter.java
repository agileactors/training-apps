package com.agileactors.converter;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.agileactors.date.DateProvider;
import com.agileactors.domain.Customer;
import com.agileactors.dto.contract.ContractDto;
import com.agileactors.dto.customer.CustomerDto;

@Component
public class CustomerToCustomerDtoConverter implements Converter<Customer, CustomerDto> {

    private final ConversionService conversionService;

    private final DateProvider dateProvider;

    @Autowired
    public CustomerToCustomerDtoConverter(ConversionService conversionService, DateProvider dateProvider) {
        this.conversionService = conversionService;
        this.dateProvider = dateProvider;
    }

    @Override
    public CustomerDto convert(Customer source) {

        var convertedContracts = new ArrayList<ContractDto>();

        if (!CollectionUtils.isEmpty(source.getContracts())) {
            source.getContracts().forEach(project -> convertedContracts.add(conversionService.convert(project, ContractDto.class)));
        }

        return new CustomerDto(source.getId(), source.getFirstName(),
            source.getLastName(), source.getEmail(), convertedContracts, dateProvider.toZonedDateTime(source.getCreatedAt()), source.getAddress());
    }
}