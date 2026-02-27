package com.example.orderservice.repository.order;

import com.example.orderservice.domain.order.Order;
import com.example.orderservice.domain.order.OrderStatus;
import com.example.orderservice.repository.base.DBModel;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class DBOrder implements DBModel {

    @Id
    private UUID id;

    @Column(name = "order_name")
    private String orderName;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Embedded
    private DBPayment payment;

    @Embedded
    private DBCustomer customer;

    @Embedded
    private DBShipping shipping;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Type(JsonBinaryType.class)
    @Column(name = "metadata", columnDefinition = "jsonb")
    private Map<String, String> metadata;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DBPayment {

        @Column(name = "total_price", precision = 19, scale = 2)
        private BigDecimal totalPrice;

        @Column(name = "currency", length = 3)
        private String currency;

        @Column(name = "card_token")
        private String cardToken;
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DBCustomer {

        @Column(name = "customer_id")
        private String customerId;

        @Column(name = "customer_name")
        private String customerName;

        @Column(name = "customer_last_name")
        private String customerLastName;

        @Column(name = "customer_email")
        private String customerEmail;

        @Column(name = "customer_phone")
        private String customerPhone;
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DBShipping {

        @Column(name = "shipping_country")
        private String shippingCountry;

        @Column(name = "shipping_state")
        private String shippingState;

        @Column(name = "shipping_city")
        private String shippingCity;

        @Column(name = "shipping_postal_code")
        private String shippingPostalCode;

        @Column(name = "shipping_address", length = 500)
        private String shippingAddress;

        @Column(name = "shipping_type")
        private String shippingType;
    }
}
