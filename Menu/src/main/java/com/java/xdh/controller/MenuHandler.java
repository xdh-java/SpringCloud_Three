package com.java.xdh.controller;

import com.java.xdh.entity.Menu;
import com.java.xdh.repository.MenuRepository;
import com.java.xdh.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 薛登辉
 * @time 2021/1/17 0017 23:37
 * @description 这是我的代码风格
 */
@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuRepository menuRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "当前的端口为:"+this.port;
    }

   /* //测试mybatis
    @GetMapping("/findAll/{index}/{limit}")
    public List<Menu> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        List<Menu> menuList = menuRepository.findAll(index, limit);
        return menuList;
    }*/
    //返回layui需要的数据格式

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVo findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        int count = menuRepository.count();
        return new MenuVo(0,"",count,menuRepository.findAll(index,limit));
    }




}
