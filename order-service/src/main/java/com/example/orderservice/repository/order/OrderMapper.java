package com.example.orderservice.repository.order;

import com.example.orderservice.domain.order.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toDomain(DBOrder dbOrder);
    DBOrder toEntity(Order order);

    Payment toDomain(DBOrder.DBPayment dbPayment);
    DBOrder.DBPayment toEntity(Payment payment);

    Customer toDomain(DBOrder.DBCustomer dbCustomer);
    DBOrder.DBCustomer toEntity(Customer customer);

    Shipping toDomain(DBOrder.DBShipping dbShipping);
    DBOrder.DBShipping toEntity(Shipping shipping);

    default String orderStatusToString(OrderStatus orderStatus) {
        return orderStatus != null ? orderStatus.name() : null;
    }

    default OrderStatus stringToOrderStatus(String orderStatus) {
        return orderStatus != null ? OrderStatus.valueOf(orderStatus) : null;
    }
}