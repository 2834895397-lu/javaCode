package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMappper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;



//可以在类的名字上加上缓存的配置, 抽取公共的缓存部分
@CacheConfig(cacheNames="emp")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMappper employeeMappper;
    /*
     * 将方法的运行结果进行缓存, 以后再要相同的数据, 直接从缓存中获取, 不用调用方法
     *
     * CacheManager管理多个Cache组件, 对缓存真正的CRUD操作在Cache组件中, 每一个缓存组件都有自己的唯一一个名字
     * 几个属性:
     *   cacheNames/value: 指定缓存组件的名字; 将方法的返回结果放在哪个缓存中, 是数组的方式, 可以指定多个缓存!
     *   key: 缓存数据使用的key, 可以用它来指定, 默认是使用方法参数的值
     *       编写SpEL: #id; 参数id的值   #a0  #p0  #root.args[0]都是表示方法的第一个参数的值
     *           getEmp[2]
     *   keyGenerator: key的生成器, 可以自己指定key的生成器的组件id
     *       key/keyGenerator: 二选一使用
     *   CacheManager: 指定缓存管理器, 或者cacheResolver指定获取解析器
     *
     *   condition: 指定符合条件下的情况下才缓存, 例如: condition="#id>0"
     *
     *   unless: 否定缓存, 当cunless指定的条件为true, 方法的返回值就不会被缓存, 可以获取到结果进行判断
     *       unless="#result==null"
     *
     *   sync: 是否异步? 异步模式的时候unless不支持
     * */


    /*
    * 原理:
    *   1. 自动配置原理:CacheAutoConfiguration
    *   2. 缓存的配置类:
    *   0 = "org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration"
        1 = "org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration"
        2 = "org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration"
        3 = "org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration"
        4 = "org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration"
        5 = "org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration"
        6 = "org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration"
        7 = "org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration"
        8 = "org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration"[默认开启]
        9 = "org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration"
            可以使用debug=true查看哪个缓存配置生效

         * 3. 那个默认配置类生效? SimpleCacheConfiguration
         * 4. 给容器中注册了一个CacheManager: ConcurrentMapCacheManager
         * 5. 可以获取和创建ConcurrentMapCache类型的缓存组件; 他的作用将数据保存在ConcurrentMap中
         *
         *  运行流程:
         *  @cacheable:
         *      1. 方法运行之前, 先去查询Cache(缓存组件), 按照cacheNames指定的名字获取;
         *          (CachManager先获取对应的缓存), 第一次获取缓存如果没有cache组件会自动创建.
         *      2. 去cache中查找缓存的内容, 使用一个key, 默认就是方法的参数;
         *              key是按照某种策略生成的, 默认是使用keyGenerator生成的, 默认使用SimpleKeyGenerator生成key
         *      3. 没有查到缓存就调用目标方法
         *      4. 目标方法返回的结果放进缓存中
         *
         *
         *      @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据, 默认按照参数的值作为key去查询查询缓存
         *       如果没有就运行方法, 并将返回结果放进缓存
         *
         *  核心:
         *      1. 使用CacheManager[ConcurrentMapCacheManager]按照名字得到Cache[ConcurrentMapCache]组件
         *      2. key使用keyGenerator生成的, 默认是SimpleKeyGenerator
         *
         *
         *
*
    * */
    //当参数的id大于0的时候缓存才生效, 如果第一个参数的值等于2缓存不生效
    @Cacheable(/*cacheNames = {"emp"},*/ /*key = "#root.methodName+'['+#id+']'"*/ /*keyGenerator = "myKeyGenerator", *//*condition = "#id > 0", unless = "#a0 == 2"*/)
    public Employee getEmp(Integer id) {
        System.out.println("查询" + id + "号员工");
        Employee emp = employeeMappper.getEmpById(id);
        return emp;
    }

    /*
     * @CachePut: 既调用方法, 又更新缓存数据
     * 修改了数据库的某个数据, 同时更新缓存
     * 运行时机:
     *      1. 先调用目标方法
     *      2. 将目标方法的结果缓存起来
     *
     * 测试步骤:
     *      1. 查询1号员工, 查到的结果会放到缓存钟
                key:1  value: lastName: zhangsan
     *      2.以后查询还是之前的结果
     *      3. 更新1号员工: [LastName: zhangsan, gender: 0]
     *              将方法的返回值也放进缓存了.
     *              key: 传入的employee对象  value: 返回的employee对象
     *      4. 查询1号员工?
     *              应该是更新之后的员工, :
     *                  key="#employee.id": 使用传入的参数的员工的id
     *                  key="#result.id": 使用返回值的id
     *                  @Cacheable的key不能使用#result, 因为在没有返回之前就要使用key来查对应的返回结果
     *      注意: 是否有自己的键的生成话策略, 否则也会更新缓存不成功
     * 总结: 在使用@CachePut的时候, 不仅要指定缓存的名字, 还要指定缓存的key, 已确保能够正确的更新缓存
     * */
    /*
    * 更新缓存的原则:  跟新缓存应注意缓存的名字和缓存使用的的key都要跟要更新的缓存一样才能达到更新缓存的效果
    * */
    @CachePut(/*value = "emp", */key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        employeeMappper.updateEmp(employee);
        System.out.println("updateEmp:" + employee);
        return employee;
    }

    /*
    * @CacheEvict: 清除缓存
    *  key: 指定要清除的数据
    *   allEntries:默认是false, 是否要删除掉所有缓存
    *   beforeInvocation: 缓存的清除是否在方法执行之前, 默认是false
    *       默认代表缓存清除操作是在方法执之后执行; 如果出现异常缓存就不会被清除
    *       如果是rue, 则无论如何都会清除缓存
    * */

    @CacheEvict(/*value = "emp", */key = "#id")
    public void deleteEmp(Integer id){
        employeeMappper.deleteEmpById(id);
    }


    //定义复杂的缓存规则
    @Caching(
            cacheable = {@Cacheable(/*value = "emp", */key = "#lastName")},
            put = {
                    @CachePut(/*value = {"emp"},*/ key = "#result.id"),
                    @CachePut(/*value = "emp",*/ key = "#result.email")
            }
    )
    public Employee getEmployeeByLastName(String lastName){
        return employeeMappper.getEmpByLastName(lastName);
    }


}
