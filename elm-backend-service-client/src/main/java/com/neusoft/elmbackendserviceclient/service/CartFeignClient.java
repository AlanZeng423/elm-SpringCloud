package com.neusoft.elmbackendserviceclient.service;


import com.neusoft.elmbackendmodel.model.vo.CartVo;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
@FeignClient(name = "elm-backend-cart-service", path = "/api/cart/inner")
public interface CartFeignClient {
    public List<CartVo> listCart(Integer cartId, String userId, Integer businessId);

    public int saveCart(Integer cartId, Integer businessId, Integer foodId);

    public int updateCart(Integer businessId, Integer foodId, String userId, Integer quantity);

    public int removeCart(String userId, Integer businessId, Integer foodId);
}
