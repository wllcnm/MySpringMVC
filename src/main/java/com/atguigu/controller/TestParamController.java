package com.atguigu.controller;


import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class TestParamController {

    @RequestMapping("/param/servletApi")
    public String getParamByServletApi(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("账号:"+username+" 密码"+password);


        return "success";
    }

    @RequestMapping("/param")
    public String getParamByMVC(@RequestParam(value = "username",defaultValue = "hello",required = true) String name,
                                @RequestParam(value = "password",required = false) String password) {
        System.out.println("账号:"+name+" 密码"+password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByMVCPojo(User user)  {
        System.out.println(user);
        return "success";
    }


}
