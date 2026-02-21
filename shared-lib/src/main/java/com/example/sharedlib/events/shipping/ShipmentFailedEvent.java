package com.example.sharedlib.events.shipping;

import com.example.sharedlib.events.base.BasePayload;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ShipmentFailedEvent implements BasePayload {
    String orderId;
    String customerId;
    String orderName;
    String reason;
}
