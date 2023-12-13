package com.agileactors.dao;

import com.agileactors.dto.contract.GetContractDto;
import com.agileactors.dto.event.PlatformEvent;

public interface PlatformEventProducer {
  void recordContractPlatformEvent(PlatformEvent<GetContractDto> abstractPlatformEvent);
}
