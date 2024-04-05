package com.neusoft.elmbackendserviceclient.service;


import com.neusoft.elmbackendmodel.model.vo.OrdersVo;

import java.util.List;

public interface OrdersService {
    public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal);

    public OrdersVo getOrdersById(Integer orderId);

    public List<OrdersVo> listOrdersByUserId(String userId);

    public int updateOrder(Integer orderId, Integer orderState);

    public int updateOrders(Integer orderId, Double orderTotal);
}
