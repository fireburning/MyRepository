package com.test.dao;

import com.test.entity.Student;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangxs on 2017/6/5.
 */
public class StudentDAOTest {

    @Test
    public void testQuery() throws SQLException, ClassNotFoundException, IOException {
        StudentDAO studentDAO = new StudenDAOImpl();
        List<Student> students= studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + " ,name:" + student.getName()
                    + " ,age:" +student.getAge());
        }
    }

    @Test
    public void testSave() throws SQLException, ClassNotFoundException, IOException {
        StudentDAO studentDAO = new StudenDAOImpl();
        Student student = new Student();
        student.setName("test");
        student.setAge(20);
        studentDAO.save(student);
    }

}
