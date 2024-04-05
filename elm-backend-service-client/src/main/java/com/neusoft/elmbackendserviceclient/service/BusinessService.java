package com.neusoft.elmbackendserviceclient.service;



import com.neusoft.elmbackendmodel.model.vo.BusinessVo;

import java.util.List;

public interface BusinessService {
    public List<BusinessVo> listBusinessByOrderTypeId(Integer orderTypeId);

    public BusinessVo getBusinessById(Integer businessId);

    public List<BusinessVo> listBusinessByBusinessName(String businessName);
}



