package com.foodOrder.foodOrderApp.service;

import com.foodOrder.foodOrderApp.api.v1.web.models.APIFood;
import com.foodOrder.foodOrderApp.dao.FoodsDao;
import com.foodOrder.foodOrderApp.service.mapper.APIFoodMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodService {

    private final FoodsDao foodsDao;

    public FoodService(FoodsDao foodsDao, APIFoodMapper apiFoodMapper) {
        this.foodsDao = foodsDao;
        this.apiFoodMapper = apiFoodMapper;
    }

    private final APIFoodMapper apiFoodMapper;
    public List<APIFood> getFoods(){

        return foodsDao.getAllFoods()
                .stream()
                .map(apiFoodMapper::daoToApi)
                .toList();
    }

}
