package com.java.xdh.controller;

import com.java.xdh.entity.UserInfo;
import com.java.xdh.repository.UserRepository;
import com.java.xdh.vo.UserVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 15:53
 * @description 这是我的代码风格
 */
@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{index}/{limit}")
    public UserVo findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        List<UserInfo> userList = userRepository.findAll(index, limit);
        UserVo userVo = new UserVo();
        userVo.setCode(0);
        userVo.setCount(userRepository.count());
        userVo.setMsg("");
        userVo.setData(userList);
        return userVo;
    }
    //统计总记录数
    @GetMapping("/count")
    public int count(){
        return userRepository.count();
    }
    //根据id查找所有
    @GetMapping("/findUserById/{id}")
    public UserInfo findUserById(@PathVariable("id") int id){
        return userRepository.findUserById(id);
    }
    //保存方法
    @PostMapping("/save")
    public void save(@RequestBody UserInfo userInfo){
        userRepository.save(userInfo);
    }
    //修改操作
    @PutMapping("/update")
    public void update(@RequestBody UserInfo userInfo){
        userRepository.update(userInfo);
    }
    //根据id进行删除操作
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){
        userRepository.deleteById(id);
    }
}
