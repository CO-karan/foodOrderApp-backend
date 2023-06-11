package com.foodOrder.foodOrderApp.dao.model;

public enum OrderStatus {
    ORDERED(1),
    CANCELED(2);
    private final int id;

    OrderStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
