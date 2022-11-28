package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestRestController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String GetAllUser(){
        System.out.println("获取所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    public String GetUserById(@PathVariable("userId") Integer userId){
        System.out.println("获取所有用户id为"+userId);
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String AddUser(){
        System.out.println("添加用户信息");
        return "success";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String UpdateUser(){
        System.out.println("修改用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.DELETE)
    public String DeleteUser(@PathVariable("userId") Integer userId){
        System.out.println("删除用户"+userId+"的信息");
        return "success";
    }


}
