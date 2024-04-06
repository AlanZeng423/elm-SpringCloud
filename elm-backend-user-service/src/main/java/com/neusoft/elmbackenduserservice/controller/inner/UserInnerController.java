package com.neusoft.elmbackenduserservice.controller.inner;

import com.neusoft.elmbackendserviceclient.service.UserFeignClient;
import com.neusoft.elmbackenduserservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/inner")
public class UserInnerController implements UserFeignClient {

    @Resource
    private UserService userService;

    @Override
    @GetMapping("/get/id")
    public int getUserById(@RequestParam("userId") String userId) {
        return userService.getUserById(userId);
    }
}
