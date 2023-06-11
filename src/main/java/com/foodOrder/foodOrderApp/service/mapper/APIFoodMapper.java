package com.foodOrder.foodOrderApp.service.mapper;

import com.foodOrder.foodOrderApp.api.v1.web.models.APIFood;
import com.foodOrder.foodOrderApp.api.v1.web.models.APIOrder;
import com.foodOrder.foodOrderApp.dao.model.Food;
import com.foodOrder.foodOrderApp.dao.model.Order;
import com.foodOrder.foodOrderApp.dao.model.OrderStatus;
import com.foodOrder.foodOrderApp.service.model.CurrencySymbols;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class APIFoodMapper {
    public APIFood daoToApi(Food foodItem){
        return new APIFood(
                foodItem.getFoodId().toString(),
                foodItem.getName(),
                foodItem.getDescription(),
                foodItem.getPrice()
//                getPriceWithCurrency(foodItem.getPrice(),foodItem.getCurrency())
        );

    }

    public Order apiTodao(APIOrder apiOrder){
        return new Order(null,apiOrder.getUserId(), OrderStatus.ORDERED,null,null);

    }
    //TODO add table for country and refernce character from that table
    private String getPriceWithCurrency(String price,String currency){
        return CurrencySymbols.fromRaw(currency).getSymbol().concat(price);
    }

}
