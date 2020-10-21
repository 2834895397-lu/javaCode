package com.jacklu.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jacklu.mybatisplus.mapper.User1Mapper;
import com.jacklu.mybatisplus.mapper.UserMapper;
import com.jacklu.mybatisplus.pojo.User;
import com.jacklu.mybatisplus.pojo.User_1;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.Null;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.management.Agent;

import java.sql.Date;
import java.util.*;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    User1Mapper user1Mapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.selectList(null));
    }

    //    测试插入
    @Test
    public void testInsert() {
        User user = new User();
        user.setId(7L);
        user.setAge(3);
        user.setName("jacklu");
        user.setEmail("2343345@qq.com");
        userMapper.updateById(user);
    }

    @Test
    public void testOptimisticLocker() {
        //模拟线程一:
        User user1 = userMapper.selectById(1L);
        user1.setName("jacklu111");

        //模拟线程二:
        User user2 = userMapper.selectById(1L);
        user2.setName("jacklu222");
        userMapper.updateById(user2);
        userMapper.updateById(user1);
        //由于乐观锁机制, 所以更新的结果为: jacklu222
    }

    @Test
    public void testSelectByBantchId() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4, 5));
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        //自定义条件查询
        map.put("name", "jacklu222");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //    测试分页查询
    @Test
    public void testPage() {
        Page<User> page = new Page<>(2, 5);

        Page<User> userPage = userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(userPage.getTotal());
    }

    //    测试逻辑删除
    @Test
    public void testLogicDelete() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        userMapper.deleteByMap(map);
    }

    //    条件查询Wrapper
//    注意: 被逻辑删除了的是不会被查询出来的
    @Test
    void testWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age", 12);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void test1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 3, 21);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

//    测试模糊查询
    @Test
    void test2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("name", "e")
//                t%
                .likeRight("email", "t");
        List<User> users = userMapper.selectList(wrapper);
            users.forEach(System.out::println);

    }

//    内连接查询
    @Test
    void test3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        id 在子查询中查询出来  也就是  id in (select id from ....)
        wrapper.inSql("id", "select id from user where id > 5");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);

    }


    @Test
    public void test4(){

        /**找出时间相交的记录
         * SELECT * FROM test_table
         * WHERE
         *     (date1 >= start AND date1 <= end)
         *     OR (date1 <= start AND date2 >= end)
         *     OR (date2 >= start AND date2 <= end)
         */

        QueryWrapper<User_1> wrapper = new QueryWrapper<>();
        //模拟date:
        String start = "2020-03-04";
        String end = "2020-08-23";

        Date date = new Date(System.currentTimeMillis());
        wrapper.inSql("name1",
                "select name1 from user_1 where (date1 >= '"+start+"' AND date1 <= '"+end+"') OR" +
                        " (date1 <= '"+start+"' AND date2 >= '"+end+"') OR " +
                        "(date2 >= '"+start+"' AND date2 <= '"+end+"')");
        List<User_1> users = user1Mapper.selectList(wrapper);
        if(!users.isEmpty()){
            System.out.println("有时间相交!");
        }
        users.forEach(System.out::println);



    }


}
