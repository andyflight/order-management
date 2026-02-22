package com.example.orderservice.api.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class OrderResponse {
    String orderId;
    String customerId;
    String orderName;
    String orderStatus;
}
