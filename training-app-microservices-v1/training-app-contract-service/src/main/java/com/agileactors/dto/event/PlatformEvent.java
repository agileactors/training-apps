package com.agileactors.dto.event;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

@JsonSerialize
public class PlatformEvent<T> implements Serializable {

  @JsonSerialize
  private final T payload;
  @JsonSerialize
  private final PlatformEventType platformEventType;

  public PlatformEvent(T payload, PlatformEventType platformEventType) {
    this.payload = payload;
    this.platformEventType = platformEventType;
  }

  @Override
  public String toString() {
    return "PlatformEvent{" +
        "payload=" + payload +
        ", platformEventType=" + platformEventType +
        '}';
  }
}
