package com.java.xdh.controller;
import com.java.xdh.entity.AdminInfo;
import com.java.xdh.entity.UserInfo;
import com.java.xdh.feign.AccountFeign;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 20:22
 * @description 这是我的代码风格
 */
//登录
@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session) {
        Object object = accountFeign.login(username, password, type);
        //因为需要一个LinkedHashMap，所以这里需要强制转换一下子
        LinkedHashMap<String, Object> hashMap = (LinkedHashMap) object;
        String result = null;
        if (object == null) {
            result = "login";
        } else {
            switch (type) {
                case "user":
                    UserInfo user = new UserInfo();
                    String idstr = hashMap.get("id")+"";
                    long id = Long.parseLong(idstr);
                    String nickname = (String) hashMap.get("nickname");
                    user.setId((int) id);
                    user.setNickname(nickname);
                    session.setAttribute("user",user);
                    result = "index";
                    break;
                case "admin":
                    AdminInfo admin = (AdminInfo)object;
                    session.setAttribute("admin",admin);
                    result = "";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/redirect/{url}")
    public String index(@PathVariable("url") String url){
        return url;
    }

}
