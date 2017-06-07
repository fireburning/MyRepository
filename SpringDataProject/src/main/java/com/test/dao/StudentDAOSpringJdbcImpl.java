package com.test.dao;

import com.test.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2017/6/6.
 */
public class StudentDAOSpringJdbcImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    public List<Student> query() {
        String sql = "select * from student";
        final List<Student> students = new ArrayList<Student>();

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);

                students.add(student);
            }
        });
        return students;
    }

    public void save(Student student) {

        String sql = "insert into student(name,age) values(?,?)";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()});
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
