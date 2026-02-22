package com.example.orderservice.api.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.Map;

@Value
@Builder
@Jacksonized
public class OrderRequest {
    String orderName;
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
    Map<String, String> metadata;
}
