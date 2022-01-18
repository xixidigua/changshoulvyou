package com.yida.changshoulvyoudemo.web;

import com.yida.changshoulvyoudemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===" + request.getRequestURL());
        HttpSession session = request.getSession(false);
    /*    if (session != null){
            String name = (String) session.getAttribute("currentName");
        String pwd = (String) session.getAttribute("currentPwd");
        if (name != null && pwd != null && employeeService.isValid(name, pwd)) {
            return true;//放行
        }
    }*/
      //  response.sendRedirect(request.getContextPath() + "/userLogin");//重定向login
        return true;//放行
    }
}
