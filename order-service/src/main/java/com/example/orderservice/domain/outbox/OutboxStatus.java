package com.example.orderservice.domain.outbox;

public enum OutboxStatus {
    PENDING,
    PROCESSING,
    COMPLETED
}
