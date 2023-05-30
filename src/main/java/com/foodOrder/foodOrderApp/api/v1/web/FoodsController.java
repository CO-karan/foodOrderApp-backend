package com.foodOrder.foodOrderApp.api.v1.web;

import com.foodOrder.foodOrderApp.api.v1.web.models.APIFood;
import com.foodOrder.foodOrderApp.service.FoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/foods")
public class FoodsController {

    private final FoodService foodService;

    public FoodsController(FoodService foodService) {
        this.foodService = foodService;
    }


    @GetMapping
    public List<APIFood> getFoods(){
        return foodService.getFoods();
    }


}
