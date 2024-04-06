package com.neusoft.elmbackendfoodservice.controller;


import com.neusoft.elmbackendcommon.common.BaseResponse;
import com.neusoft.elmbackendcommon.common.ErrorCode;
import com.neusoft.elmbackendcommon.common.ResultUtils;
import com.neusoft.elmbackendcommon.exception.BusinessException;
import com.neusoft.elmbackendfoodservice.service.FoodService;
import com.neusoft.elmbackendmodel.model.vo.FoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/lists/{businessId}")
    public BaseResponse<List<FoodVo>> listFoodByBusinessId(@PathVariable(value = "businessId") Integer businessId) throws Exception {
        if (businessId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<FoodVo> foodVoList = foodService.listFoodByBusinessId(businessId);
        if (foodVoList != null) {
            return ResultUtils.success(foodVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取当前商家的商品列表失败");
        }
    }

}
