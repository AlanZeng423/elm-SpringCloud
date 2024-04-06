package com.neusoft.elmbackendfoodservice.mapper;


import com.neusoft.elmbackendmodel.model.bo.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface FoodMapper {
    @Select("select * from food where businessId=#{businessId} order by foodId")
    public List<Food> listFoodByBusinessId(Integer businessId) throws SQLException;

    @Select("select * from food where foodId=#{foodId}")
    public Food getFoodById(Integer foodId) throws SQLException;
}