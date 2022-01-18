package com.yida.changshoulvyoudemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一的异常处理类
 */
@ControllerAdvice //异常类（重要）
@Slf4j
public class HandlerException {
    @ExceptionHandler(RuntimeException.class)
    public String exceptionPage(Exception e, Model model) {
        if (e instanceof UnknownAccountException) {
            log.info("登录认证失败,用户不存在! 原因="+e.getMessage());
            model.addAttribute("loginError", "登录认证失败,用户不存在!");
            return "login";
        } else if (e instanceof LockedAccountException) {
            log.info("登录认证失败,用户被禁用! 原因="+e.getMessage());
            model.addAttribute("loginError", "登录认证失败,用户被禁用!");
            return "login";
        } else if (e instanceof IncorrectCredentialsException) {
            log.info("登录认证失败,密码不正确! 原因="+e.getMessage());
            model.addAttribute("loginError", "登录认证失败,密码不正确!");
            return "login";
        } else if (e instanceof AuthenticationException) {
            log.info("登录认证失败! 原因="+e.getMessage());
            model.addAttribute("loginError", e.getMessage());
            return "login";
        } else if (e instanceof UnauthorizedException) {
            log.info("授权认证失败,未授权访问! 原因="+e.getMessage());
            return "unauthorized";
        } else if (e instanceof UnauthenticatedException) {
            log.info("授权认证失败,没有登录! 原因="+e.getMessage());
            model.addAttribute("loginError","授权认证失败,没有登录!");
            return "login";
        } else if (e instanceof AuthorizationException) {
            log.info("授权认证失败! 原因="+e.getMessage());
            return "unauthorized";
        }
        else { // RuntimeException
            //...
        }

        log.info(e.getMessage());
        return "redirect:/login";
    }

     /*@ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public R exceptionInfo(Exception e) {
        String msg = null;
        int code = ResponseCode.API_CODE_CALL_UNAUTHORIZED;
        if (e instanceof UnknownAccountException) {
            log.info("登录认证失败,用户不存在! 原因="+e.getMessage());
            return R.error(e.getMessage());
        } else if (e instanceof LockedAccountException) {
            log.info("登录认证失败,用户被禁用! 原因="+e.getMessage());
            return R.error(e.getMessage());
        } else if (e instanceof IncorrectCredentialsException) {
            log.info("登录认证失败,密码不正确! 原因="+e.getMessage());
            return R.error("登录密码不正确");
        } else if (e instanceof AuthenticationException) {
            log.info("登录认证失败! 原因="+e.getMessage());
            return R.error("登录认证失败");
        } else if (e instanceof UnauthorizedException) {
            msg = "授权认证失败,未授权访问!";
        } else if (e instanceof UnauthenticatedException) {
            msg = "授权认证失败,没有登录!";
        } else if (e instanceof AuthorizationException) {
            msg = "授权认证失败!";
        } else {
            msg = e.getMessage();
        }

        log.info(msg+"原因="+e.getMessage());
        return R.error(code, msg);
    }*/


}
