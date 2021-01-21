package com.java.xdh.repository;

import com.java.xdh.entity.UserInfo;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 19:26
 * @description 这是我的代码风格
 */
public interface UserInfoRepository {
    public UserInfo login(String username,String password);
}
