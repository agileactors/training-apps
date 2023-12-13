package com.agileactors.service;

import com.agileactors.domain.AuditLogType;
import com.agileactors.dto.audit.CreateAuditLogRequestDto;
import com.agileactors.dto.contract.GetContractDto;
import com.agileactors.dto.event.PlatformEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PlatformEventsConsumerServiceImpl {

  private final ObjectMapper objectMapper;
  private final AuditLogService auditLogService;

  public PlatformEventsConsumerServiceImpl(
      ObjectMapper objectMapper,
      AuditLogService auditLogService
  ) {
    this.objectMapper = objectMapper;
    this.auditLogService = auditLogService;
  }

  @KafkaListener(topics = "${spring.kafka.producer.topic-id}")
  public void processMessage(String platformEventAsString) throws JsonProcessingException {
    TypeReference<PlatformEvent<GetContractDto>> typeRef =
        new TypeReference<PlatformEvent<GetContractDto>>() {
        };

    var platformEvent = objectMapper.readValue(platformEventAsString, typeRef);

    auditLogService.save(
        new CreateAuditLogRequestDto(AuditLogType.CONTRACT_INIT, platformEvent.getPayload().id()));
  }
}
