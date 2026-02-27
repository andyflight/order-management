package com.example.orderservice.repository.outbox;

import com.example.orderservice.domain.outbox.OutboxStatus;
import com.example.orderservice.repository.base.DBModel;
import com.example.sharedlib.events.base.BasePayload;
import com.example.sharedlib.events.base.Event;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "outbox_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DBOutbox implements DBModel {

    @Id
    private UUID id;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    @Column(name = "aggregate_id", nullable = false)
    private String aggregateId;

    @Column(name = "topic", nullable = false)
    private String topic;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OutboxStatus status;

    @Type(JsonBinaryType.class)
    @Column(name = "event", columnDefinition = "jsonb", nullable = false)
    private Event<BasePayload> event;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "processed_at")
    private Instant processedAt;

    @Column(name = "retry_count")
    private Integer retryCount;
}