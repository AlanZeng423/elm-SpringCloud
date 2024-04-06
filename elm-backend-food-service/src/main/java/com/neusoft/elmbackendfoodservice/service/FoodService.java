package com.neusoft.elmbackendfoodservice.service;


import com.neusoft.elmbackendmodel.model.vo.FoodVo;

import java.util.List;

public interface FoodService {
    public List<FoodVo> listFoodByBusinessId(Integer businessId);
}