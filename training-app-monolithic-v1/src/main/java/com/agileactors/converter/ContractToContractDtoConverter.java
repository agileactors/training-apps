package com.agileactors.converter;

import com.agileactors.domain.Contract;
import com.agileactors.dto.contract.GetContractDto;
import com.agileactors.dto.customer.GetCustomerDto;
import java.time.Instant;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ContractToContractDtoConverter implements Converter<Contract, GetContractDto> {

  @Override
  public GetContractDto convert(Contract source) {
    var customerDto =
        new GetCustomerDto(source.getCustomer().getId(), source.getCustomer().getFirstName(),
            source.getCustomer().getLastName(), source.getCustomer().getEmail(),
            null, source.getCreatedAt(), source.getCustomer().getAddress());

    return new GetContractDto(source.getId(), source.getName(), source.getCreatedAt(),
        source.getUpdatedAt(), source.getContractType(),
        customerDto, source.getCost(), source.getEngagementDate(),
        source.getEndDate());
  }

}
