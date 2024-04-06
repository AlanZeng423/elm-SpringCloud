package com.neusoft.elmbackendcartservice.service;


import com.neusoft.elmbackendmodel.model.vo.CartVo;

import java.util.List;

public interface CartService {
    public List<CartVo> listCart(Integer cartId, String userId, Integer businessId);

    public int saveCart(Integer cartId, Integer businessId, Integer foodId);

    public int updateCart(Integer businessId, Integer foodId, String userId, Integer quantity);

    public int removeCart(String userId, Integer businessId, Integer foodId);
}
