package models;

import enums.OrderStatus;

import java.time.LocalDateTime;

public class Order {
    private int orderId;
    private int customerId;
    private LocalDateTime orderDate;
    private OrderStatus status;

    // 1. For fetching from DB (We know the ID and the Date the DB recorded)
    public Order(int orderId, int customerId, LocalDateTime orderDate, OrderStatus status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
    }

    // 2. For creating a NEW order (ID and Date are usually handled by PostgreSQL)
    public Order(int customerId, OrderStatus status) {
        this.customerId = customerId;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
