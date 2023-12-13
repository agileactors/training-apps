package com.agileactors.dao;

import com.agileactors.dto.contract.GetContractDto;
import com.agileactors.dto.event.PlatformEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
class PlatformEventProducerImpl implements PlatformEventProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;
  private final String platformEventsTopicId;
  private final ObjectMapper objectMapper;

  @Autowired
  public PlatformEventProducerImpl(
      KafkaTemplate<String, String> kafkaTemplate,
      @Value("${spring.kafka.producer.topic-id}") String platformEventsTopicId,
      ObjectMapper objectMapper
  ) {
    this.kafkaTemplate = kafkaTemplate;
    this.platformEventsTopicId = platformEventsTopicId;
    this.objectMapper = objectMapper;
  }

  /**
   * When we publish messages with a key to a Kafka topic, all messages with the same key are guaranteed to be
   * stored in the same partition by Kafka.
   * Thus, keys in Kafka messages are useful if we want to maintain order for messages having the same key.
   *
   * @param contractPlatformEvent
   */
  public void recordContractPlatformEvent(PlatformEvent<GetContractDto> contractPlatformEvent) {
    try {
      kafkaTemplate.send(platformEventsTopicId,
          objectMapper.writeValueAsString(contractPlatformEvent));
      System.out.println("Message sent: " + objectMapper.writeValueAsString(contractPlatformEvent));
    } catch (Exception e) {
      System.out.println(e);
    }
  }

//  public static void main(String[] args) throws JsonProcessingException {
//
//    var string = new ObjectMapper().writeValueAsString(
//        new ContractPlatformEvent(new GetContractDto(UUID.randomUUID(), "name",
//            Instant.now(), Instant.now(), ContractType.FIXED, 100L, Instant.now(), Instant.now()),
//            PlatformEventType.CONTRACT_CREATED));
//
//    System.out.println(string);
//  }

}
