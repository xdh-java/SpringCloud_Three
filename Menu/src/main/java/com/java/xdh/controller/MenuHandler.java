package com.java.xdh.controller;

import com.java.xdh.entity.Menu;
import com.java.xdh.entity.Type;
import com.java.xdh.repository.MenuRepository;
import com.java.xdh.repository.TypeRepository;
import com.java.xdh.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private TypeRepository typeRepository;

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

    //获取type里面的所有属性
    @GetMapping("/findAllTypes")
    public List<Type> findAllTypes(){
        return typeRepository.findAllTypes();
    }
    //保存的方法
    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuRepository.save(menu);
    }
    //删除的方法
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){
        menuRepository.deleteById(id);
    }
    //修改的操作，此操作是比较麻烦的。
    //1、先要拿到修改的id属性
    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuRepository.findById(id);
    }
    //根据id查询出了所有的属性
    //然后开始更新操作
    @PutMapping("/update")
    public void updateMenu(@RequestBody Menu menu){
        menuRepository.update(menu);
    }






}
