package com.neusoft.elmbackendserviceclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "elm-backend-user-service", path = "/api/user/inner")
public interface UserFeignClient {

    /**
     * 根据userId获取Id列表
     * 项目比较简单，跨域的请求只有getUserById这一个方法
     * @param userId
     * @return
     */
    @GetMapping("/get/id")
    public int getUserById(@RequestParam("userId") String userId);


}
