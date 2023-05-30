package com.foodOrder.foodOrderApp.api.v1.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class APIFood{

    private String id;
    private String name;
    private String description;
    private String price;
}
