package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/*
* 在配置类上使用@MapperScan注解, 指定了扫描的包就不用每个mapper都使用@Mapper注解
* */
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("delete * from department where id = #{id}")
    public int deleteDeptById(Integer id);

    //自动拆箱
    //使用自动生成的主键, 这样在没有插入主键的时候返回的数据就有主键了, 并且明确主键是id
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name = #{departmentName} where id = #{id}")
    public int updateDept(Department department);

}
