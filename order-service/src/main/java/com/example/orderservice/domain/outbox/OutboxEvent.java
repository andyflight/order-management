package com.example.orderservice.domain.outbox;

import com.example.orderservice.domain.base.DomainModel;
import lombok.Data;

import java.util.UUID;

@Data
public class OutboxEvent implements DomainModel {
    private UUID id;
}
