package com.foodOrder.foodOrderApp.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Order {
    UUID orderId;
    UUID userId;
    OrderStatus status;
    Instant createdDate;
    Instant lastUpdated;
}
