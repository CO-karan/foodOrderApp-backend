package com.foodOrder.foodOrderApp.service.mapper;

import com.foodOrder.foodOrderApp.api.v1.web.models.APIFood;
import com.foodOrder.foodOrderApp.dao.model.Food;
import com.foodOrder.foodOrderApp.service.model.CurrencySymbols;
import org.springframework.stereotype.Component;

@Component
public class APIFoodMapper {
    public APIFood daoToApi(Food foodItem){
        return new APIFood(
                foodItem.getFoodId().toString(),
                foodItem.getName(),
                foodItem.getDescription(),
                getPriceWithCurrency(foodItem.getPrice(),foodItem.getCurrency())
        );

    }
    private String getPriceWithCurrency(String price,String currency){
        return CurrencySymbols.fromRaw(currency).getSymbol().concat(price);
    }

}
