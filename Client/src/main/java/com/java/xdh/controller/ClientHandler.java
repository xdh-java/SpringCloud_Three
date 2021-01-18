package com.java.xdh.controller;

import com.java.xdh.feign.MenuFeign;
import com.java.xdh.vo.MenuVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * @author 薛登辉
 * @time 2021/1/18 0018 19:58
 * @description 这是我的代码风格
 */
@Controller
@RequestMapping("/client")
@Slf4j
public class ClientHandler {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll/{index}/{limit}")
    @ResponseBody
    public MenuVo findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        return menuFeign.findAll(index, limit);
    }

    @GetMapping("/redirect/{url}")
    public String index(@PathVariable("url") String url){
        return url;
    }
    //问号传参
    //封装前端的参数请求(msg,data,count,code)
    @GetMapping("/findAll")
    @ResponseBody
    public MenuVo findAllMenu(@RequestParam("page") int page,@RequestParam("limit") int limit){
        int index = (page - 1)*limit;
        return menuFeign.findAll(index,limit);
    }

}
