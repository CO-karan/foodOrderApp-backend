package com.foodOrder.foodOrderApp.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class Food {

    private UUID foodId;
    private String name;
    private String description;
    private String price;
    private String currency;
}
