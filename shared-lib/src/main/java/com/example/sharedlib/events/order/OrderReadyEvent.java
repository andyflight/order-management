package com.example.sharedlib.events.order;

import com.example.sharedlib.events.base.BasePayload;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.Map;

@Value
@Builder
@Jacksonized
public class OrderReadyEvent implements BasePayload {
    String orderId;
    String customerId;
    BigDecimal totalPrice;
    String currency;

    String recipientName;
    String recipientPhone;

    String deliveryCity;
    String deliveryStreet;
    String deliveryType;
    Map<String, String> metadata;
}
