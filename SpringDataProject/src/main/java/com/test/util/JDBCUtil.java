package com.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by zhangxs on 2017/6/5.
 */
public class JDBCUtil {

    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {

//        最原始写法
//        String url = "jdbc:mysql:///spring_data";
//        String user = "root";
//        String password = "123456";
//        String driverClass = "com.mysql.jdbc.Driver";
//
//        Class.forName(driverClass);
//        Connection connection = DriverManager.getConnection(url,user,password);

//        配置文件写法
        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,password);

        return connection;
    }

    public static void release(ResultSet resultSet, Statement statement, Connection connection){

        if( resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if( statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if( connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
