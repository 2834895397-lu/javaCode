package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Employee;

//使用映射文件的方法来把mapper加入到容器中
public interface EmployeeMaper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
