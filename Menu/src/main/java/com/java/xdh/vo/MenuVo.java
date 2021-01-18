package com.java.xdh.vo;

import com.java.xdh.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 薛登辉
 * @time 2021/1/18 0018 20:32
 * @description 这是我的代码风格
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVo {
    private int code;
    private String msg;
    private int count;
    private List<Menu> data;
}
