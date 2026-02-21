package com.example.orderservice.common;

import com.example.sharedlib.events.base.BasePayload;
import com.example.sharedlib.events.base.Event;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
@NoArgsConstructor
public class EventFactory {

    public Event<BasePayload> create(BasePayload payload) {

        return Event.builder()
                .eventId(UUID.randomUUID().toString())
                .eventType(payload.getClass().getSimpleName())
                .payload(payload)
                .timestamp(Instant.now())
                .version(1)
                .source("order-service")
                .aggregateId(payload.getOrderId())
                .correlationId(payload.getOrderId())
                .build();
    }
}
