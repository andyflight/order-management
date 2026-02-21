package com.example.sharedlib.events.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;
import java.util.UUID;

@Value
@Builder
@Jacksonized
public class Event<T extends BasePayload> {
    String eventId;
    String eventType;
    Instant timestamp;
    String aggregateId;
    String correlationId;
    Integer version;
    String source;
    T payload;
}