package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PortalController {

//    @RequestMapping(value = "/")
//    public String portal() {
//        return "index";
//    }

    @RequestMapping("/test/ajax")
    public String ToAjax() {
        return "Ajax";
    }


}
