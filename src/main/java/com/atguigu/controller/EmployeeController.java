package com.atguigu.controller;

import com.atguigu.Dao.EmployeeDao;
import com.atguigu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/employee")
    public String getAllEmp(Model model) {
        Collection<Employee> allEmployee = employeeDao.getAll();
        model.addAttribute("allEmployee", allEmployee);
        return "employee_list";
    }

    @RequestMapping("/to/add")
    public String ToAddEmp() {
        return "employee_add";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST )
    public String AddEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.GET )
    public String ToUpdateEmp(@PathVariable("empId") Integer empId,Model model) {
        Employee employee = employeeDao.get(empId);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT )
    public String UpdateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.DELETE )
    public String UpdateEmp(@PathVariable("empId") Integer empId) {
        employeeDao.delete(empId);
        return "redirect:/employee";
    }




}
