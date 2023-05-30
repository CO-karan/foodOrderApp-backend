package com.foodOrder.foodOrderApp.dao;
import com.foodOrder.foodOrderApp.dao.mapper.FoodMapper;
import com.foodOrder.foodOrderApp.dao.model.Food;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodsDao{
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public FoodsDao(NamedParameterJdbcTemplate jdbcTemplate, FoodMapper foodMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.foodMapper = foodMapper;
    }

    private final FoodMapper foodMapper;

    public List<Food> getAllFoods(){
        var sql = "SELECT * FROM FOODS";
        return jdbcTemplate.query(sql,foodMapper);
    }
}
