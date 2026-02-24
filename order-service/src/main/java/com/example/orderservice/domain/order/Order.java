package com.example.orderservice.domain.order;

import com.example.orderservice.domain.base.DomainModel;
import com.example.sharedlib.events.order.OrderCancelledEvent;
import com.example.sharedlib.events.order.OrderCreatedEvent;
import com.example.sharedlib.events.order.OrderFailedEvent;
import com.example.sharedlib.events.order.OrderSucceedEvent;
import lombok.Builder;
import lombok.Value;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Order implements DomainModel {
    UUID id;
    String orderName;
    String orderStatus;
    Payment payment;
    Customer customer;
    Shipping shipping;
    Instant createdAt;
    Instant updatedAt;
    Map<String, String> metadata;

    public OrderCreatedEvent toOrderCreatedEvent() {
        // TODO
        return null;
    }

    public OrderCancelledEvent toOrderCancelledEvent() {
        // TODO
        return null;
    }

    public OrderFailedEvent toOrderFailedEvent() {
        // TODO
        return null;
    }

    public OrderSucceedEvent toOrderSucceedEvent() {
        // TODO
        return null;
    }
}
