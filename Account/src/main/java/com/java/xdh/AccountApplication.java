package com.java.xdh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 薛登辉
 * @time 2021/1/20 0020 19:16
 * @description 这是我的代码风格
 */
@SpringBootApplication
@MapperScan("com.java.xdh.repository")
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class,args);
    }
}
