package com.example.orderservice.domain.order;

import com.example.orderservice.domain.base.DomainModel;
import com.example.sharedlib.events.order.OrderCancelledEvent;
import com.example.sharedlib.events.order.OrderCreatedEvent;
import com.example.sharedlib.events.order.OrderFailedEvent;
import com.example.sharedlib.events.order.OrderSucceedEvent;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class Order implements DomainModel {
    private UUID id;
    String orderName;
    String orderStatus;
    String paymentStatus;
    BigDecimal totalPrice;
    String currency;
    String customerId;
    String customerName;
    String customerLastName;
    String customerEmail;
    String customerPhone;
    String shippingCountry;
    String shippingState;
    String shippingCity;
    String shippingPostalCode;
    String shippingAddress;
    String shippingType;
    String cardToken;
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
