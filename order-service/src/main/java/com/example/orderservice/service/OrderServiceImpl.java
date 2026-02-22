package com.example.orderservice.service;

import com.example.orderservice.api.dto.OrderRequest;
import com.example.orderservice.api.dto.OrderResponse;
import com.example.orderservice.common.EventFactory;
import com.example.orderservice.common.IdGenerator;
import com.example.orderservice.common.JsonMapper;
import com.example.orderservice.domain.order.Order;
import com.example.orderservice.domain.outbox.OutboxEvent;
import com.example.orderservice.service.usecases.SaveOrderUseCase;
import com.example.orderservice.service.usecases.SaveOutboxUseCase;
import com.example.sharedlib.events.order.OrderCreatedEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final SaveOrderUseCase saveOrderUseCase;
    private final SaveOutboxUseCase saveOutboxUseCase;

    @Override
    @Transactional
    public OrderResponse processOrder(OrderRequest order) {
        var orderId = IdGenerator.generateId();
        var orderToSave = Order.builder()
                .id(orderId)
                .build();
        var savedOrder = saveOrderUseCase.saveOrder(orderToSave);
        var orderCreatedEvent = savedOrder.toOrderCreatedEvent();
        var event = EventFactory.create(orderCreatedEvent);
        var outboxId = IdGenerator.generateId();
        var outbox = OutboxEvent.builder()
                .id(outboxId)
                .eventType(orderCreatedEvent.getClass().getSimpleName())
                .status("PENDING")
                .event(event)
                .createdAt(Instant.now())
                .build();
        saveOutboxUseCase.saveOutboxEvent(outbox);

        return OrderResponse.builder()
                .orderId(savedOrder.getId().toString())
                .build();
    }
}
