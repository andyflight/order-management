package com.example.orderservice.repository.outbox;

import com.example.orderservice.domain.outbox.OutboxEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OutboxMapper {

    OutboxEvent toDomain(DBOutbox dbOutboxEvent);

    DBOutbox toEntity(OutboxEvent outboxEvent);

    List<OutboxEvent> toDomainList(List<DBOutbox> dbOutboxEvents);
}