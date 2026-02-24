package com.example.orderservice.domain.order;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder(toBuilder = true)
public class Payment {
    BigDecimal totalPrice;
    String currency;
    String cardToken;
}
