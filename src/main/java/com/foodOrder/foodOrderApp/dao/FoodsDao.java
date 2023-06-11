package com.foodOrder.foodOrderApp.dao;
import com.foodOrder.foodOrderApp.api.v1.web.models.CartItem;
import com.foodOrder.foodOrderApp.dao.mapper.FoodMapper;
import com.foodOrder.foodOrderApp.dao.model.Food;
import com.foodOrder.foodOrderApp.dao.model.Order;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.foodOrder.foodOrderApp.uitls.MapUtils.mapOf;

@Repository
@RequiredArgsConstructor
public class FoodsDao{
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final FoodMapper foodMapper;

    public List<Food> getAllFoods(){
        var sql = "SELECT * FROM FOODS";
        return jdbcTemplate.query(sql,foodMapper);
    }

    @SuppressWarnings("unchecked")
    public UUID createOrder(Order order, CartItem[] orderedMeals) {
        //Todo move order insert to order dao
        var orderTrackInsert= """
                INSERT INTO ORDER_TRACK(USERID,STATUS,CREATED_DATE,LAST_UPDATED)
                            OUTPUT INSERTED.ORDERID
                            VALUES(:userId,:status,:createdDate,:lastUpdated);
                """;

        //insert Order
        var orderId = jdbcTemplate.queryForObject(orderTrackInsert,
                mapOf(
                        "userId",order.getUserId(),
                        "status",order.getStatus().getId(),
                        "createdDate", Timestamp.from(Instant.now()),
                        "lastUpdated",null// could be null as its creation
                ),
                UUID.class
        );

        //insert foods
        var ordersInsert = """
                INSERT INTO ORDERS(ORDERID,FOODID,AMOUNT) VALUES(:orderId,:foodId,:amount)
                """;
        Map<String,Object>[] arr= (Map<String, Object>[]) new Map<?,?>[orderedMeals.length];
        int index=0;
        for(var orderedMeal:orderedMeals){
            UUID id = UUID.fromString(orderedMeal.getMealId());
            int amount = orderedMeal.getAmount();
            MapSqlParameterSource itemParams = new MapSqlParameterSource();
            itemParams.addValue("orderId",orderId);
            itemParams.addValue("foodId",id);
            itemParams.addValue("amount",amount);
            arr[index] = itemParams.getValues();
            index++;
        }
        jdbcTemplate.batchUpdate(ordersInsert, arr);

        return orderId;
    }
}
