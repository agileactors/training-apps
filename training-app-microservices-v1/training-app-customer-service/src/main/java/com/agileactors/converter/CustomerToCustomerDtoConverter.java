package com.agileactors.converter;

import com.agileactors.domain.Customer;
import com.agileactors.dto.customer.GetCustomerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDtoConverter implements Converter<Customer, GetCustomerDto> {

  @Override
  public GetCustomerDto convert(Customer source) {

    return new GetCustomerDto(source.getId(), source.getFirstName(),
        source.getLastName(), source.getEmail(), source.getCreatedAt(), source.getAddress());
  }
}
