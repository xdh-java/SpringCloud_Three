package com.java.xdh.repository;

import com.java.xdh.entity.Type;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author 薛登辉
 * @time 2021/1/18 0018 22:27
 * @description 这是我的代码风格
 */
public interface TypeRepository {
    public Type findById(long id);
    public List<Type> findAllTypes();
}
