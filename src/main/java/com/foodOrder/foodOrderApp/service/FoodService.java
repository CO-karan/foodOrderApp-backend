package com.foodOrder.foodOrderApp.service;

import com.foodOrder.foodOrderApp.api.v1.web.models.APIFood;
import com.foodOrder.foodOrderApp.api.v1.web.models.APIOrder;
import com.foodOrder.foodOrderApp.dao.FoodsDao;
import com.foodOrder.foodOrderApp.dao.model.Order;
import com.foodOrder.foodOrderApp.service.mapper.APIFoodMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodsDao foodsDao;

    private final APIFoodMapper apiFoodMapper;

    public List<APIFood> getFoods(){

        return foodsDao.getAllFoods()
                .stream()
                .map(apiFoodMapper::daoToApi)
                .toList();
    }

    public String placeOrder(APIOrder apiOrder) {
        //validate payload

        //Store data
        Order newOrder = apiFoodMapper.apiTodao(apiOrder);
        return foodsDao.createOrder(newOrder,apiOrder.getCartItems()).toString();

    }
}
