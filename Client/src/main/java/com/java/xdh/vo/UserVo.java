package com.java.xdh.vo;

import com.java.xdh.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 16:39
 * @description 这是我的代码风格
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private int code;
    private String msg;
    private int count;
    public List<UserInfo> data;
}
