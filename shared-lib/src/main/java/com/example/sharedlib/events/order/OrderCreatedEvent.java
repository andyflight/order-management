package com.example.sharedlib.events.order;

import com.example.sharedlib.events.base.BasePayload;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Value
@Builder
@Jacksonized
public class OrderCreatedEvent implements BasePayload {
    String orderId;
    String customerId;
    BigDecimal totalPrice;
    String currency;
    String orderName;
    String country;
    String state;
    String city;
    String postalCode;
    String address;
    String customerName;
    String customerLastName;
    String customerEmail;
    String customerPhone;
    String paymentToken;
}
