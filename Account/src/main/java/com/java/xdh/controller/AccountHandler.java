package com.java.xdh.controller;

import com.java.xdh.entity.AdminInfo;
import com.java.xdh.entity.UserInfo;
import com.java.xdh.repository.AdminRepository;
import com.java.xdh.repository.UserInfoRepository;
import org.omg.CORBA.ObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 19:29
 * @description 这是我的代码风格
 */
@RestController
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }
    //管理员用户登录
    @PostMapping("/login")
    public Object loginUser(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("type") String type){
       Object result = null;
        switch (type){
            case "admin":
                AdminInfo login = adminRepository.login(username, password);
                result =  login;
                break;
            case "user":
                UserInfo userLogin = userInfoRepository.login(username, password);
                result = userLogin;
                break;
        }
        return result;
    }
}
