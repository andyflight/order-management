package com.example.sharedlib.events.payment;

import com.example.sharedlib.events.base.BasePayload;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class PaymentFailedEvent implements BasePayload {
    String orderId;
    String customerId;
    String orderName;
    String reason;
}
