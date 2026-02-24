package com.example.orderservice.domain.order;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Customer {
    String customerId;
    String customerName;
    String customerLastName;
    String customerEmail;
    String customerPhone;
}
