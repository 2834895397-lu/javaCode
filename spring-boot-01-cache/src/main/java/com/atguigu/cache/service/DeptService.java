package com.atguigu.cache.service;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DeptService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    CacheManager cacheManager;

    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id) {
        System.out.println("查询部门id:" + id);
        Department department = departmentMapper.getDeptById(id);

        //代码的方式添加缓存获取某个缓存
        //使用缓存管理器得到缓存, 进行api调用
        Cache cache = cacheManager.getCache("dept");
        cache.put("自己定义的缓存", department);


        return department;


    }
}
