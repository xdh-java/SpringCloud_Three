package com.java.xdh.repository;
import com.java.xdh.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 薛登辉
 * @time 2021/1/17 0017 23:26
 * @description 这是我的代码风格
 */
public interface MenuRepository {

    public List<Menu> findAll(int index,int limit);
    public int count();
    public Menu findById(long id);
    public void save(Menu menu);
    public void update(Menu menu);
    public void deleteById(long id);

}
