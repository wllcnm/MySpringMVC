package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
public class TestSessionAndApplicationController {

    @RequestMapping("/session")
    public String testSession(HttpSession session){
        session.setAttribute("scopeID","hello,session");
        return "success";
    }

    @RequestMapping("/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("scopeID","hello,application");
        return "success";
    }

}
