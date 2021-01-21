package com.java.xdh.repository;

import com.java.xdh.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 14:33
 * @description 这是我的代码风格
 */
@Repository
public interface UserRepository {
    //分页查询所有数据
    public List<UserInfo> findAll(int index,int limit);
    //统计数量
    public int count();
    //通过id查询所有
    public UserInfo findUserById(long id);
    //保存的操作
    public void save(UserInfo userInfo);
    //修改操作
    public void update(UserInfo userInfo);
    //根据id进行删除操作
    public void deleteById(long id);

}
