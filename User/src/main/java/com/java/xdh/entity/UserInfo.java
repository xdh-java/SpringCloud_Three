package com.java.xdh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 14:30
 * @description 这是我的代码风格
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private Date registerdate;
    private String address;

}
