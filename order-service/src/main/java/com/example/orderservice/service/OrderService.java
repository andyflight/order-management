package com.example.orderservice.service;

import com.example.orderservice.api.dto.OrderRequest;
import com.example.orderservice.api.dto.OrderResponse;

public interface OrderService {

    OrderResponse processOrder(OrderRequest order);
}
