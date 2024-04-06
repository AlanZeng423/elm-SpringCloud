package com.neusoft.elmbackendserviceclient.service;


import com.neusoft.elmbackendmodel.model.vo.TransactionFlowVo;
import com.neusoft.elmbackendmodel.model.vo.VirtualWalletVo;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
@FeignClient(name = "elm-backend-virtualWallet-service", path = "/api/virtualWallet/inner")
public interface VirtualWalletFeignClient {
    /**
     * 新建钱包
     *
     * @param userId
     * @return
     */
    int saveWallet(String userId);

    /**
     * 查看虚拟钱包
     *
     * @param userId
     * @return
     */
    VirtualWalletVo getWallet(String userId);

    /**
     * 充钱
     *
     * @param userId
     * @param amount
     * @return
     */
    int recharge(String userId, Integer amount);

    /**
     * 消费
     *
     * @param userId
     * @param amount
     * @return
     */
    int expense(String userId, Integer amount);

    /**
     * 提现
     *
     * @param userId
     * @param amount
     * @param target
     * @return
     */
    Integer withdraw(String userId, Integer amount, String target);

    /**
     * 查询交易流水
     *
     * @param userId
     * @return
     */
    List<TransactionFlowVo> getLog(String userId);
}
