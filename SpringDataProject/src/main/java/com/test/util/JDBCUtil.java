package com.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by zhang on 2017/6/5.
 */
public class JDBCUtil {

    public  static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String url = (String) properties.get("jdbc.url");
        String user = (String) properties.get("jdbc.user");
        String password = (String) properties.get("jdbc.password");
        String driverClass = (String) properties.get("jdbc.driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }

    public static void release(ResultSet resultSet, Statement statement,Connection connection){

        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
