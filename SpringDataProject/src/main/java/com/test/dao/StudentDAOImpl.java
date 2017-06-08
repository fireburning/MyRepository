package com.test.dao;

import com.test.entity.Student;
import com.test.util.JDBCUtil;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxs on 2017/6/5.
 */
public class StudentDAOImpl implements StudentDAO{

    public List<Student> query(){

        Connection connection = null;
        PreparedStatement prepareStatement = null;
//        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from student";
        List<Student> students = new ArrayList<Student>();

        try {
            connection = JDBCUtil.getConnection();
            prepareStatement = connection.prepareStatement(sql);
//            statement = connection.createStatement();
            resultSet = prepareStatement.executeQuery();
//            resultSet = statement.executeQuery(sql);
            Student student = null;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                students.add(student);
                }

            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,prepareStatement,connection);
//            JDBCUtil.release(resultSet,statement,connection);
        }
        return students;
    }

    public void save(Student student){

        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet resultSet = null;
        String sql = "insert into student(name,age) values(?,?)";

        try {
            connection = JDBCUtil.getConnection();
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1,student.getName());
            prepareStatement.setInt(2,student.getAge());
            prepareStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,prepareStatement,connection);
        }
    }
}
