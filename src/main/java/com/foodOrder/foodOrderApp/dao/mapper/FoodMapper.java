package com.foodOrder.foodOrderApp.dao.mapper;

import com.foodOrder.foodOrderApp.dao.model.Food;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
@Component
public class FoodMapper implements RowMapper<Food> {

    @Override
    public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Food(
                rs.getObject("FOODID", UUID.class),
                rs.getString("NAME"),
                rs.getString("DESCRIPTION"),
                rs.getString("PRICE"),
                rs.getString("currency")
        );

    }
}
