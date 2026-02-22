package com.example.orderservice.service.usecases;

import com.example.orderservice.domain.outbox.OutboxEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SaveOutboxUseCase {

    @Transactional(propagation = Propagation.MANDATORY)
    public void saveOutboxEvent(OutboxEvent outboxEvent) {

    }
}
