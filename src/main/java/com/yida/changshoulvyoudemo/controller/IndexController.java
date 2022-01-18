package com.yida.changshoulvyoudemo.controller;


import com.yida.changshoulvyoudemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-12-28 21:24:36
 */

@Slf4j
@Controller
public class IndexController {

    @Resource
    private UserService userService;
    @Value("${server.port}")
    private  Integer port;
    @GetMapping(value={"/","/login"})
    public String  login(Model model) {
        model.addAttribute("port",port);
        return "login";
    }

    @PostMapping("/loginData")
    public String loginData(@RequestParam("name") String name,
                            @RequestParam("password") String password, Model model
                            ){
        System.out.println("娃哈哈");
        String tmpName = name.trim();
        String tmpPwd = password.trim();
        if(StringUtils.isEmpty(tmpName)|| StringUtils.isEmpty(tmpPwd )){
            model.addAttribute("loginError", "用户名或密码不能为空");
            log.info("用户名或密码不能为空");
            return "login";
        }
        //shiro登录认证
        Subject subject = SecurityUtils.getSubject();//获取主题对象
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, password);
        subject.login(usernamePasswordToken);
        return "redirect:/index";
    }
    @GetMapping("unauthorized")
    public String  unauthorizedPage() {
        return "unauthorized";
    }
}

