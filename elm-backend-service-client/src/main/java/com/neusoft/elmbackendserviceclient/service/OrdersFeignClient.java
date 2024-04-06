package com.neusoft.elmbackendserviceclient.service;


import com.neusoft.elmbackendmodel.model.vo.OrdersVo;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
@FeignClient(name = "elm-backend-orders-service", path = "/api/orders/inner")
public interface OrdersFeignClient {
    public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal);

    public OrdersVo getOrdersById(Integer orderId);

    public List<OrdersVo> listOrdersByUserId(String userId);

    public int updateOrder(Integer orderId, Integer orderState);

    public int updateOrders(Integer orderId, Double orderTotal);
}
