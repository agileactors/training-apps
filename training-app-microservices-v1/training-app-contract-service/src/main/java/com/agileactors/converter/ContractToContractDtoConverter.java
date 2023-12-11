package com.agileactors.converter;

import com.agileactors.domain.Contract;
import com.agileactors.dto.contract.GetContractDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ContractToContractDtoConverter implements Converter<Contract, GetContractDto> {

  @Override
  public GetContractDto convert(Contract source) {
    return new GetContractDto(source.getId(), source.getName(), source.getCreatedAt(),
        source.getUpdatedAt(), source.getContractType(), source.getCost(),
        source.getEngagementDate(),
        source.getEndDate());
  }
}
