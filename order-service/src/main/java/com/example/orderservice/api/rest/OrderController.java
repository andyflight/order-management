package com.example.orderservice.api.rest;

import com.example.orderservice.api.dto.OrderRequest;
import com.example.orderservice.api.dto.OrderResponse;
import com.example.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;


    @PostMapping("/api/v1/orders")
    ResponseEntity<OrderResponse> createOrder(
            @RequestBody OrderRequest body 
    ) {
        OrderResponse orderResponse = orderService.processOrder(body);
        
        return ResponseEntity.ok(orderResponse);
    }
}
