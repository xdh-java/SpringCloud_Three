package com.java.xdh.repository;

import com.java.xdh.entity.UserInfo;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * @author 薛登辉
 * @time 2021/1/20 0020 15:20
 * @description 这是我的代码风格
 */
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findAll() {
        List<UserInfo> list = userRepository.findAll(0, 10);
        System.out.println(list.toString());
    }

    @Test
    void count() {
        int count = userRepository.count();
        System.out.println(count);
    }

    @Test
    void findUserById() {
        UserInfo user = userRepository.findUserById(2);
        System.out.println(user);
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}