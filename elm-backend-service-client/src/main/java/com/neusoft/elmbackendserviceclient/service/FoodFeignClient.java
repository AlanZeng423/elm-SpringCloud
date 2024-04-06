package com.neusoft.elmbackendserviceclient.service;


import com.neusoft.elmbackendmodel.model.vo.FoodVo;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
@FeignClient(name = "elm-backend-food-service", path = "/api/food/inner")
public interface FoodFeignClient {
    public List<FoodVo> listFoodByBusinessId(Integer businessId);
}