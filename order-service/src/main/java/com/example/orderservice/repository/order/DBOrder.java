package com.example.orderservice.repository.order;

import com.example.orderservice.domain.order.Order;
import com.example.orderservice.repository.base.DBModel;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
public class DBOrder implements DBModel {

    @Id
    private UUID id;
    String orderName;
    String orderStatus;
    String paymentStatus;
    BigDecimal totalPrice;
    String currency;
    String customerId;
    String customerName;
    String customerLastName;
    String customerEmail;
    String customerPhone;
    String shippingCountry;
    String shippingState;
    String shippingCity;
    String shippingPostalCode;
    String shippingAddress;
    String shippingType;
    String cardToken;
    Instant createdAt;
    Instant updatedAt;
    @Type(JsonBinaryType.class)
    @Column(name = "metadata", columnDefinition = "jsonb")
    private Map<String, String> metadata;

    public Order toDomain() {
        return Order.builder().build();
    }

    public static DBOrder fromDomain(Order order) {
        var dbOrder = new DBOrder();
        dbOrder.setId(order.getId());
        return dbOrder;
    }
}
