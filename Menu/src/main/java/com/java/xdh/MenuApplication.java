package com.java.xdh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 薛登辉
 * @time 2021/1/17 0017 23:24
 * @description 这是我的代码风格
 */
@SpringBootApplication
@MapperScan("com.java.xdh.repository")
public class MenuApplication {
    public static void main(String[] args) {
        SpringApplication.run(MenuApplication.class,args);
    }
}
