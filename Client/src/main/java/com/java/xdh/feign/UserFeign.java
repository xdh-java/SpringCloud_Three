package com.java.xdh.feign;

import com.java.xdh.entity.UserInfo;
import com.java.xdh.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 16:28
 * @description 这是我的代码风格
 */
@FeignClient(value = "user")
public interface UserFeign {

    //查询所有
    @GetMapping("/user/findAll/{page}/{limit}")
    public UserVo findAll(@PathVariable("page") int index, @PathVariable("limit") int limit);
    //根据id查询所有
    @GetMapping("/user/findAllById/{id}")
    public UserInfo findUserById(@PathVariable("id") int id);
    //统计记录数
    @GetMapping("/user/count")
    public int count();
    //保存操作
    @PostMapping("/user/save")
    public void save( UserInfo userInfo);
    //修改操作
    @PutMapping("/user/update")
    public void update( UserInfo userInfo);
    //根据id进行删除操作
    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id);
}
