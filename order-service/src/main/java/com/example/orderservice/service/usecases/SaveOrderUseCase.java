package com.example.orderservice.service.usecases;

import com.example.orderservice.domain.order.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SaveOrderUseCase {

    @Transactional(propagation = Propagation.MANDATORY)
    public Order saveOrder(Order order) {

        return null;
    }
}
