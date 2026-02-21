package com.example.orderservice.domain.order;

import com.example.orderservice.domain.base.DomainModel;
import com.example.sharedlib.events.order.OrderCancelledEvent;
import com.example.sharedlib.events.order.OrderCreatedEvent;
import com.example.sharedlib.events.order.OrderFailedEvent;
import com.example.sharedlib.events.order.OrderSucceedEvent;
import lombok.Data;

import java.util.UUID;

@Data
public class Order implements DomainModel {
    private UUID id;

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
