package com.java.xdh.repository;

import com.java.xdh.entity.AdminInfo;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 19:19
 * @description 这是我的代码风格
 */
public interface AdminRepository {
    //根据账户和密码查询所有
    public AdminInfo login(String username,String password);
}
