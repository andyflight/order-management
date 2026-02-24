package com.example.sharedlib.events.base;


public interface BasePayload {
    String getOrderId();

    String getCustomerId();

    String getOrderName();
}
