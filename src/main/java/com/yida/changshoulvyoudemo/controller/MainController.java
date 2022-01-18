package com.yida.changshoulvyoudemo.controller;

import com.yida.changshoulvyoudemo.entity.User;
import com.yida.changshoulvyoudemo.exception.R;
import com.yida.changshoulvyoudemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于注解方式的授权认证
 */

@Controller

public class MainController {
    @Autowired
    private UserService userService;
    @Value("${server.port}")
    private  Integer port;
    @GetMapping(value={"/","/index"})
     public String mainPage(Model model) {
        model.addAttribute("port",port);
        return "index";
    }


    //基于角色的权限认证
    //@RequiresRoles("admin") //单角色认证,符合就通过
    //@RequiresRoles(value = {"admin", "user"}, logical = Logical.AND) //多角色认证,logical默认为AND,全部符合才通过
   @RequiresRoles(value = {"admin", "user"}, logical = Logical.OR) //多角色认证,有一个符合就通过
    //基于权限字符串的权限认证
    //@RequiresPermissions("user:select:01") //单个权限字符串认证,符合就通过
    //@RequiresPermissions(value = {"user:select:*", "user:crate:*"}, logical = Logical.AND) //多权限字符串认证,logical默认为AND，全部符合才通过
    //@RequiresPermissions(value = {"order:select:*", "user:crate:*"}, logical = Logical.OR) //多权限字符串认证,有一个符合就通过
    @GetMapping(value={"/addUserPage"})
    public String addUserPage(){
        return "add";
    }
    @GetMapping(value={"/main"})
    public String userManage(){
        return "main";
    }

     @ResponseBody
    @PostMapping("/addUser")
     //@RequiresRoles("admin") //单角色认证,符合就通过
     @RequiresRoles(value = {"admin", "user"}, logical = Logical.OR) //多角色认证,有一个符合就通过
     @Transactional //添加事务 重要  才能保证和role一起成功 外界先调用它  自动传播到IPMl后面 重要
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("password" )String password
                          ){
        userService.addUser(name, password);
        return  "添加用户成功";
     }
@GetMapping("/findAll")
@RequiresRoles(value={"admin", "user"}, logical = Logical.OR) //只允许角色为:管理员(admin) 或者 普通用户(user) 才能访问
    public  String queryAllUserPage(Model model){
        //查询数据库...然后存储到model
    List<User> users = userService.queryAllUsers();
    model.addAttribute("users",users);
    System.out.println(users);
    return  "find";
}
    @GetMapping("/findSelf")
    @RequiresPermissions("user:select:*") //只有拥有查看用户权字符串的，都可以访问
    public String queryUserPage(Model model) {
        //获取主题对象
        Subject subject = SecurityUtils.getSubject();
        //通过主题对象获取用户名
        String username = (String)subject.getPrincipal();
        //根据用户名查询数据库，获取用户信息
        User user = userService.getUserByName(username);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        model.addAttribute("users", users);
        return "find";
    }
    @GetMapping("/updateSelf")
    @RequiresPermissions(value = {"user:update:*", "user:select:*"}) //拥有前用户修改+用户查询的权限字符串，才能访问
    public String updateUserPage(Model model) {
        //获取主题对象
        Subject subject = SecurityUtils.getSubject();
        //通过主题对象获取用户名
        String username = (String)subject.getPrincipal();
        //根据用户名查询数据库，获取用户信息
        User user = userService.getUserByName(username);
        model.addAttribute("user", user);
        return "update";
    }
    //修改用户
    @GetMapping("/updateUserName")
    @RequiresPermissions(value = {"user:update:*", "user:select:*"}) //拥有前用户修改+用户查询的权限字符串，才能访问
    public String updateUser(Model model,@RequestParam("name") String name) {

        User user = userService.getUserByName(name);
        model.addAttribute("user", user);
        return "update";
    }
   //删除用户
   @ResponseBody
   @GetMapping("/deleteUserName")
   @RequiresPermissions("user:delete:*") //拥有前用户修改+用户查询的权限字符串，才能访问
   @Transactional //添加事务 重要  才能保证和role一起成功 外界先调用它  自动传播到IPMl后面 重要
   public String deleteUserName(@RequestParam("name") String name) {

        userService.deleteByName(name);
       return  "删除用户成功";
   }
    @ResponseBody
    @PostMapping("/updateUser")
    @RequiresPermissions(value = {"user:update:*", "user:select:*"}) //拥有前用户修改+用户查询的权限字符串，才能访问
    @Transactional
    public R updateUser(User user) {
        System.out.println(user);
        return userService.updateUser(user);
    }
}
