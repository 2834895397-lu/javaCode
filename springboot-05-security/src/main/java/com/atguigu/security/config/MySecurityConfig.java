package com.atguigu.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启登录功能
        /*
        * 默认规则:
        *  1. /login来到登录页面
        *  2. 重定向到/login?error表示登录失败
        *  3. 更多详细规定
        *  4. 默认post形式的/login代表处理登录
        *
        * */
        http.formLogin().loginPage("/userlogin");

        //开启自动配置的注销功能
        //1. 访问/logout表示用户注销, 清空session
        //2. 注销成功之后会返回/login?logout页面
        //可以自定义注销成功之后来到的页面
        http.logout().logoutSuccessUrl("/");

        //开启记住我功能
        //登录成功之后, 将cookie发送给浏览器保存, 以后访问页面带上这个cookie, 只要通过检查就都可以免登录
        //点击注销会删除cookie
        http.rememberMe().rememberMeParameter("remember");


    }

    /*
    * 方法一和方法二的添加用户的二选一:
    *
    * */


    //方法一添加用户, 这种方式要指定密码的加密方式

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("zhangsan").password("123456").roles("VIP1");
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("lisi").password("123456").roles("VIP2");
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("wangwu").password("123456").roles("VIP3");
    }

    class MyPasswordEncoder implements PasswordEncoder {

        @Override
        public String encode(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override
        public boolean matches(CharSequence charSequence, String s) {
            return s.equals(charSequence.toString());
        }

    }



    //方法二添加用户
   /* @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("jacklu")
                        .password("root")
                        .roles("VIP1","VIP2", "VIP3")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }*/
}
