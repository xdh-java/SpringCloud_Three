package com.java.xdh.controller;

import com.java.xdh.entity.UserInfo;
import com.java.xdh.feign.UserFeign;
import com.java.xdh.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 16:37
 * @description 这是我的代码风格
 */
@Controller
@RequestMapping("/user")
public class UserHandler {
    //注入userFeign
    @Autowired
    private UserFeign userFeign;

    //使用thymeleaf来解析后端数据引擎
    @GetMapping("/redirect/{url}")
    public String url(@PathVariable("url") String url){
        return url;
    }

    //查询所有
    @GetMapping("/findAll")
    @ResponseBody
    public UserVo findAllUsers(@RequestParam("page") int page,@RequestParam("limit") int limit){
        int index = (page -1 )*limit;
       return userFeign.findAll(index, limit);
    }
    //根据id进行查询操作
    @GetMapping("/findAllById/{id}")
    public UserInfo findAllById(@PathVariable("id") int id){
        UserInfo user = userFeign.findUserById(id);
        return user;
    }
    //save操作
    @PostMapping("/save")
    public String save(UserInfo userInfo){
        userFeign.save(userInfo);
        return "redirect:/user/redirect/user_manage";
    }
    //修改操作
    @PutMapping("/update")
    public void update(UserInfo userInfo){
        userFeign.update(userInfo);
    }
    //根据id进行删除
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }


}
