package com.example.orderservice.domain.order;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Shipping {
    String shippingCountry;
    String shippingState;
    String shippingCity;
    String shippingPostalCode;
    String shippingAddress;
    String shippingType;
}
