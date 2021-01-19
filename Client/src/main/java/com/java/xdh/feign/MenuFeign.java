package com.java.xdh.feign;

import com.java.xdh.entity.Menu;
import com.java.xdh.entity.Type;
import com.java.xdh.vo.MenuVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 薛登辉
 * @time 2021/1/18 0018 19:55
 * @description 这是我的代码风格
 */
@FeignClient(value = "menu")
public interface MenuFeign {
    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVo findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);
    //保存方法
    @PostMapping("/menu/save")
    public void save(Menu menu);
    //删除方法
    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id);

    //修改的第一步操作
    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") int id);

    //修改方法
    @PutMapping("/menu/update")
    public void update(Menu menu);

    //查询所有
    @GetMapping("/menu/findAllTypes")
    public List<Type> findAllTypes();
}
