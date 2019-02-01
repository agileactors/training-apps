package com.agileactors.converter;

import java.time.Instant;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.agileactors.date.DateProvider;
import com.agileactors.domain.Contract;
import com.agileactors.dto.contract.ContractDto;

@Component
public class ContractToContractDtoConverter implements Converter<Contract, ContractDto> {

    private final DateProvider dateProvider;

    @Autowired
    public ContractToContractDtoConverter(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    @Override
    public ContractDto convert(Contract source) {

        return new ContractDto(source.getId(), source.getName(), toZonedDateTime(source.getCreatedAt()),
            toZonedDateTime(source.getUpdatedAt()), source.getContractType(),
            source.getCustomerId(), source.getCost(), toZonedDateTime(source.getEngagementDate()),
            toZonedDateTime(source.getEndDate()));
    }

    private ZonedDateTime toZonedDateTime(Instant instant) {
        return dateProvider.toZonedDateTime(instant);
    }
}
