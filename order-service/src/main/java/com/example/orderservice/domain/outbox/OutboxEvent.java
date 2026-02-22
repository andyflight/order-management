package com.example.orderservice.domain.outbox;

import com.example.orderservice.domain.base.DomainModel;
import com.example.sharedlib.events.base.BasePayload;
import com.example.sharedlib.events.base.Event;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class OutboxEvent implements DomainModel {
    private UUID id;
    private String eventType;
    private Instant createdAt;
    private String status;
    private Event<BasePayload> event;
}
