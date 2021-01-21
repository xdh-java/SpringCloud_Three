package com.java.xdh.controller;

import com.java.xdh.entity.Menu;
import com.java.xdh.feign.MenuFeign;
import com.java.xdh.vo.MenuVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

  /*  @GetMapping("/findAll/{index}/{limit}")
    @ResponseBody
    public MenuVo findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        return menuFeign.findAll(index, limit);
    }
*/
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
    //删除的方法
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        menuFeign.deleteById(id);
        return "redirect:/client/redirect/menu_manage";
    }
    //添加的操作
    //跳转到添加的页面显示
    @GetMapping("/findAllTypes")
    public ModelAndView findAllTypes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list",menuFeign.findAllTypes());
        return modelAndView;
    }
    //页面上有一个请求后台save的方法
    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        System.out.println("md");
        return "redirect:/client/redirect/menu_manage";

    }
    //更新的操作
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu",menuFeign.findById(id));
        modelAndView.addObject("list",menuFeign.findAllTypes());
        return modelAndView;
    }
    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/client/redirect/menu_manage";
    }


}
