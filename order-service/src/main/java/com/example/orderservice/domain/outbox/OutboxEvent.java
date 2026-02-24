package com.example.orderservice.domain.outbox;

import com.example.orderservice.domain.base.DomainModel;
import com.example.sharedlib.events.base.BasePayload;
import com.example.sharedlib.events.base.Event;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.time.Instant;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class OutboxEvent implements DomainModel {
    UUID id;
    String eventType;
    String aggregateId;
    String topic;
    Instant createdAt;
    OutboxStatus status;
    Event<BasePayload> event;
}
