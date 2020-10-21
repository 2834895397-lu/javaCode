package com.jacklu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        System.out.println("请求进来了");
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        //1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获得连接
            Connection conn =  DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=UTC","root",""
            );
            //获得执行对象
            String sql = "select * from user where username = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,req.getParameter("username"));
            ps.setString(2,req.getParameter("password"));
            //执行sql
            ResultSet rs = ps.executeQuery();
            resp.setContentType("textml;charset=utf-8");
            if (rs.next()){
                resp.getWriter().write("login success!");

            }else {
                resp.getWriter().write("login failed!");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
