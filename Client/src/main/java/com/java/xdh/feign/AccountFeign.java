package com.java.xdh.feign;

import com.java.xdh.entity.AdminInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.function.ObjIntConsumer;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 20:24
 * @description 这是我的代码风格
 */
@FeignClient(value = "account")
public interface AccountFeign {

    //登录
    @PostMapping("/account/login")
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type);
}
