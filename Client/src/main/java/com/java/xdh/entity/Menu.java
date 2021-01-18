package com.java.xdh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 薛登辉
 * @time 2021/1/17 0017 23:25
 * @description 这是我的代码风格
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Long id;
    private String name;
    private Double price;
    private String flavor;
    //后来加入进来的。
    private  Type  type;

}
