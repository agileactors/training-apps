package com.agileactors.converter;

import com.agileactors.domain.Customer;
import com.agileactors.dto.contract.GetContractDto;
import com.agileactors.dto.customer.GetCustomerDto;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class CustomerToCustomerDtoConverter implements Converter<Customer, GetCustomerDto> {

  private final ConversionService conversionService;

  @Autowired
  public CustomerToCustomerDtoConverter(ConversionService conversionService) {
    this.conversionService = conversionService;
  }

  @Override
  public GetCustomerDto convert(Customer source) {

    var convertedContracts = new ArrayList<GetContractDto>();

    if (!CollectionUtils.isEmpty(source.getContracts())) {
      source.getContracts().forEach(project -> convertedContracts.add(
          conversionService.convert(project, GetContractDto.class)));
    }

    return new GetCustomerDto(source.getId(), source.getFirstName(),
        source.getLastName(), source.getEmail(), convertedContracts,
        source.getCreatedAt(), source.getAddress());
  }
}
