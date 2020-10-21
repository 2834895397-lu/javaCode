package com.atguigu.cache.controller;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.mapper.DepartmentMapper;
import com.atguigu.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    @RequestMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        Department dept = deptService.getDeptById(id);
        return dept;
    }
}
