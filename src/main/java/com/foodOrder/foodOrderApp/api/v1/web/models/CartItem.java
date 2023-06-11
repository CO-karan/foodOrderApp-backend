package com.foodOrder.foodOrderApp.api.v1.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class CartItem {
    @NonNull
    String mealId;
    int amount;
}

