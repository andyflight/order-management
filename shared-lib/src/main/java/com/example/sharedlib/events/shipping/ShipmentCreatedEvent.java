package com.example.sharedlib.events.shipping;

import com.example.sharedlib.events.base.BasePayload;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Value
@Builder
@Jacksonized
public class ShipmentCreatedEvent implements BasePayload {
    String orderId;
    String customerId;
    String orderName;
    String trackingNumber;
    LocalDate estimatedDeliveryDate;
}
