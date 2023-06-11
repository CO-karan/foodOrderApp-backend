package com.foodOrder.foodOrderApp.api.v1.web;

import com.foodOrder.foodOrderApp.api.v1.web.models.APIFood;
import com.foodOrder.foodOrderApp.api.v1.web.models.APIOrder;
import com.foodOrder.foodOrderApp.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = {"http://localhost:5173","http://localhost:5174"})
@RestController
@RequestMapping("v1/foods")
@RequiredArgsConstructor
public class FoodsController {

    private final FoodService foodService;

    @GetMapping
    public List<APIFood> getFoods(){
        return foodService.getFoods();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody @Validated APIOrder apiOrder){
        if(apiOrder==null) return "FAILED";
        return foodService.placeOrder(apiOrder);
    }

}
// TODO setup exceptions and respose things