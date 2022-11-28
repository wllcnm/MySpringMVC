package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/**
 * Date:2022/7/7
 * Author:ybc
 * Description:
 * 向域对象共享数据：
 * 1、通过ModelAndView向请求域共享数据
 * 使用ModelAndView时，可以使用其Model功能向请求域共享数据
 * 使用View功能设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
 * 2、使用Model向请求域共享数据
 * 3、使用ModelMap向请求域共享数据
 * 4、使用map向请求域共享数据
 * 5、Model和ModelMap和map的关系
 * 其实在底层中，这些类型的形参最终都是通过BindingAwareModelMap创建
 * public class BindingAwareModelMap extends ExtendedModelMap {}
 * public class ExtendedModelMap extends ModelMap implements Model {}
 * public class ModelMap extends LinkedHashMap<String, Object> {}
 */

@Controller
public class TestScopeController {


    @RequestMapping("/scope/modelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("scopeID", "scopeValue");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/scope/model")
    public String testModel(Model model) {

        model.addAttribute("scopeID", "hello,model");
        return "success";
    }

    @RequestMapping("/scope/modelMap")
    public String testModel(ModelMap modelMap) {
        modelMap.addAttribute("scopeID", "hello,modelMap");
        return "success";
    }

    @RequestMapping("/scope/Map")
    public String testModel(Map<String, Object> map) {

        map.put("scopeID", "hello,Map");
        return "success";
    }

}
