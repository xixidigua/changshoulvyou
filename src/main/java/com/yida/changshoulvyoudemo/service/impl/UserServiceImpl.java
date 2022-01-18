package com.yida.changshoulvyoudemo.service.impl;


import com.yida.changshoulvyoudemo.entity.User;
import com.yida.changshoulvyoudemo.exception.R;
import com.yida.changshoulvyoudemo.mapper.UserDao;
import com.yida.changshoulvyoudemo.service.UserService;
import com.yida.changshoulvyoudemo.util.SaltUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-12-28 21:24:42
 */
@Transactional //添加事务
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Value("${Credential.AlgorithmName}") //从配置参数取过来的是什么加密算法
    private  String algorithmName;
    @Value("${Credential.hashIterations}")//从配置参数取过来的是什么加密次数
    private  Integer hashIterations;
    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public void addUser(String name, String password) {
        User user = new User();
        user.setName(name);
        String salt= SaltUtils.srand(8);//盐值（让密码更安全）
        //参数说明：
        //algorithmName 加密算法名, source 要加密的密码, salt 盐值, hashIterations 加密次数
        SimpleHash newPwd = new SimpleHash(algorithmName, password, salt, hashIterations);
        user.setPassword(newPwd.toString());
        user.setSalt(salt);//添加盐值
        String time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
         user.setTime(time);
        userDao.insertSelective(user);//添加新用户
        userDao.insertUserRole(user.getId(),2);//给新用户添加一个默认角色（user,即：普通用户 根据数据库得知roleId=2）
    }

    @Override
    public List<User> queryAllUsers() {
        List<User> users = userDao.selectAll();
        return  users;
    }

    @Override
    @Transactional
    public R updateUser(User user) {
        String salt = SaltUtils.srand(8);//盐值（让密码更安全）
        //参数说明：
        //algorithmName 加密算法名, source 要加密的密码, salt 盐值, hashIterations 加密次数
        SimpleHash newPwd = new SimpleHash(algorithmName, user.getPassword(), salt, hashIterations);
        user.setPassword(newPwd.toString());
        user.setSalt(salt);//添加盐值
        userDao.updateByPrimaryKeySelective(user);//修改
        return R.ok("修改成功");
    }

    @Override
    @Transactional //添加事务 重要  才能保证和role一起成功 外界先调用它  自动传播到IPMl后面 重要
    public void deleteByName(String name) {
        User user = userDao.getUserByName(name);
        userDao.deleteById(user.getId());
        userDao.deleteByName(name);

    }
}
