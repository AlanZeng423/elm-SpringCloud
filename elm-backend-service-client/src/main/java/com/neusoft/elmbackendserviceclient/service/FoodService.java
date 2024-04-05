package com.neusoft.elmbackendserviceclient.service;


import com.neusoft.elmbackendmodel.model.vo.FoodVo;

import java.util.List;

public interface FoodService {
    public List<FoodVo> listFoodByBusinessId(Integer businessId);
}