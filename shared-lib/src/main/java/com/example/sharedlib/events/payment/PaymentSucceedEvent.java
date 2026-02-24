package com.example.sharedlib.events.payment;

import com.example.sharedlib.events.base.BasePayload;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Value
@Builder
@Jacksonized
public class PaymentSucceedEvent implements BasePayload {
    String orderId;
    String customerId;
    String orderName;
    BigDecimal totalPrice;
    String currency;
    String acquirerTransactionId;
    String approvalCode;
}
