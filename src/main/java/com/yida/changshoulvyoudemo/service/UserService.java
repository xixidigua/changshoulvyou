package com.yida.changshoulvyoudemo.service;


import com.yida.changshoulvyoudemo.entity.User;
import com.yida.changshoulvyoudemo.exception.R;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-12-28 21:24:41
 */
public interface UserService {
    public User getUserByName(String name);
    public void addUser(String name, String password);
    public List<User> queryAllUsers();
    public R updateUser(User user);
    //删除用户
    public  void deleteByName(@Param("name") String name);

}

