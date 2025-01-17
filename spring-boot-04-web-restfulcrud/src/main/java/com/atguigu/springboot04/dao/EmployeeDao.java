package com.atguigu.springboot04.dao;


import com.atguigu.springboot04.entities.Department;
import com.atguigu.springboot04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static{
		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "卢金健", "aa@163.com", 1, new Department(101, "D-AA")));
		employees.put(1002, new Employee(1002, "龚富锋", "bb@163.com", 1, new Department(102, "D-BB")));
		employees.put(1003, new Employee(1003, "钟科胜", "cc@163.com", 1, new Department(103, "D-CC")));
		employees.put(1004, new Employee(1004, "杨敏", "dd@163.com", 0, new Department(104, "D-DD")));
		employees.put(1005, new Employee(1005, "刘亦菲", "ee@163.com", 0, new Department(105, "D-EE")));
	}
	
	private static Integer initId = 1006;
	
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}
}
