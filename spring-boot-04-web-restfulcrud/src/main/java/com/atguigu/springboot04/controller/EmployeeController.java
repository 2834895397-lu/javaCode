package com.atguigu.springboot04.controller;

import com.atguigu.springboot04.dao.DepartmentDao;
import com.atguigu.springboot04.dao.EmployeeDao;
import com.atguigu.springboot04.entities.Department;
import com.atguigu.springboot04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    EmployeeDao employeeDao;

    //查询所有员工, 返回列表页面
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        // 放在请求域中
        model.addAttribute("emps", employees);

        //thymeleaf默认就会拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }

    //来到员工的添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到员工添加页面

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        return "emp/add";
    }

    @PostMapping("/emp")
    //springmvc自动将请求参数和入参对象的属性进行一一绑定
    //要求请求参数的名字和javaBean入参里面的属性名是一样的
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        //来到员工列表页面 不能写/emps, 因为没有/emps的视图
        return "redirect:/emps";
    }

    //来到修改页面, 查出当前员工, 在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee emp = employeeDao.get(id);
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("emp", emp);
        model.addAttribute("depts",depts);
        System.out.println(emp);
        //回到修改页面(add是一个添加修改二合一的页面)
        return "emp/add";
   }

   //修改员工
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @RequestMapping("/emp/del/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";

    }


}
