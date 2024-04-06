package com.neusoft.elmbackendserviceclient.service;

import com.neusoft.elmbackendmodel.model.vo.BusinessVo;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
@FeignClient(name = "elm-backend-business-service", path = "/api/business/inner")
public interface BusinessFeignClient {
    public List<BusinessVo> listBusinessByOrderTypeId(Integer orderTypeId);

    public BusinessVo getBusinessById(Integer businessId);

    public List<BusinessVo> listBusinessByBusinessName(String businessName);
}


