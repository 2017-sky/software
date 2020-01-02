package com.example.demo.util;

import com.example.demo.entity.Food;
import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;
import java.sql.*;

public class DButil {
    private static final String URL="jdbc:mysql://localhost:3306/homework?serverTimezone=GMT%2B8";
    private static final String USER="root";
    private static final String PASSWORD="123456";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("数据库连接失败");
        }
        return connection;
    }

    public static Food exuteDML(String sql, Object...objects){
        int num = 0;
        Food food = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (Object object:objects){
                preparedStatement.setObject(++num,object);
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                food = new Food();
                food.setId(resultSet.getInt("id"));
                food.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("数据库执行异常");
        }
        return food;
    }







}
