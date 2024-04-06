package com.neusoft.elmbackendserviceclient.service;


import com.neusoft.elmbackendmodel.model.vo.DeliveryAddressVo;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
@FeignClient(name = "elm-backend-deliveryAddress-service", path = "/api/deliveryAddress/inner")
public interface DeliveryAddressFeignClient {
    public List<DeliveryAddressVo> listDeliveryAddressByUserId(String userId);

    public DeliveryAddressVo getDeliveryAddressById(Integer daId);

    public int saveDeliveryAddress(String userId, String contactName, Integer contactSex, String contactTel, String address);

    public int updateDeliveryAddress(Integer daId, String contactName, Integer contactSex, String contactTel, String address);

    public int removeDeliveryAddress(Integer daId);
}