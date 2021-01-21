package com.java.xdh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 19:20
 * @description 这是我的代码风格
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminInfo {
    private int id;
    private String username;
    private String password;

}
