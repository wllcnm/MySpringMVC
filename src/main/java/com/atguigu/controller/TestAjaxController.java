package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@RestController
public class TestAjaxController {

    @RequestMapping("/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("requestBody = " + requestBody);
        System.out.println("id = " + id);
        response.getWriter().write("hello,axios");
    }

    @RequestMapping("/ajax/RequestBody/json/map")
    public void testRequestBody(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
        System.out.println("map = " + map);
        response.getWriter().write("hello,RequestBody");
    }

    @RequestMapping("/ajax/RequestBody/json/pojo")
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println("user = " + user);
        response.getWriter().write("hello,RequestBody");
    }

    @RequestMapping(value = "/ajax/ResponseBody",method = RequestMethod.POST)
    public User testResponseBody( @RequestBody User user) {
        System.out.println("接收后的"+user);
        user.setUsername("蔡徐坤");
        user.setPassword("cxknb");
        return  user;
    }

}
