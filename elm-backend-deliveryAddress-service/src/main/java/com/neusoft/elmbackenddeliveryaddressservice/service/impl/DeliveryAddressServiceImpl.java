package com.neusoft.elmbackenddeliveryaddressservice.service.impl;


import com.neusoft.elmbackenddeliveryaddressservice.mapper.DeliveryAddressMapper;
import com.neusoft.elmbackenddeliveryaddressservice.service.DeliveryAddressService;
import com.neusoft.elmbackendmodel.model.bo.DeliveryAddress;
import com.neusoft.elmbackendmodel.model.vo.DeliveryAddressVo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    @Autowired
    private DeliveryAddressMapper deliveryAddressMapper;

    @Override
    public List<DeliveryAddressVo> listDeliveryAddressByUserId(String userId) {
        try {
            List<DeliveryAddress> deliveryAddressList = deliveryAddressMapper.listDeliveryAddressByUserId(userId);
            return getDeliveryAddressVo(deliveryAddressList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public DeliveryAddressVo getDeliveryAddressById(Integer daId) {
        try {
            DeliveryAddress deliveryAddress = deliveryAddressMapper.getDeliveryAddressById(daId);
            return getDeliveryAddressVo(deliveryAddress);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int saveDeliveryAddress(String userId, String contactName, Integer contactSex, String contactTel, String address) {
        try {
            return deliveryAddressMapper.saveDeliveryAddress(userId, contactName, contactSex, contactTel, address);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int updateDeliveryAddress(Integer daId, String contactName, Integer contactSex, String contactTel, String address) {
        try {
            return deliveryAddressMapper.updateDeliveryAddress(daId, contactName, contactSex, contactTel, address);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int removeDeliveryAddress(Integer daId) {
        try {
            return deliveryAddressMapper.removeDeliveryAddress(daId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DeliveryAddressVo getDeliveryAddressVo(DeliveryAddress deliveryAddress) {
        if (deliveryAddress == null) {
            return null;
        }
        DeliveryAddressVo deliveryAddressVo = new DeliveryAddressVo();
        BeanUtils.copyProperties(deliveryAddress, deliveryAddressVo);
        return deliveryAddressVo;
    }


    public List<DeliveryAddressVo> getDeliveryAddressVo(List<DeliveryAddress> deliveryAddressList) {
        if (CollectionUtils.isEmpty(deliveryAddressList)) {
            return new ArrayList<>();
        }
        return deliveryAddressList.stream().map(this::getDeliveryAddressVo).collect(Collectors.toList());
    }
}
