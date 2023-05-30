package com.foodOrder.foodOrderApp.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class Food {
    public UUID getFoodId() {
        return foodId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public Food(UUID foodId, String name, String description, String price, String currency) {
        this.foodId = foodId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
    }

    private UUID foodId;
    private String name;
    private String description;
    private String price;
    private String currency;
}
