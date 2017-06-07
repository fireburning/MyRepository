package com.test.dao;

import com.test.entity.Student;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhang on 2017/6/6.
 */
public class StudentDAOImplTest {

    @Test
    public void testQuery() throws SQLException, IOException, ClassNotFoundException {
       StudentDAO studentDAO = new StudentDAOImpl();
       List<Student> students = studentDAO.query();
        for (Student student : students) {
                System.out.println("id:" + student.getId()
                        + " ,name:" + student.getName()
                        + " ,age:" + student.getAge());
        }
    }

    @Test
    public void testSave() throws SQLException, IOException, ClassNotFoundException {
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setName("test");
        student.setAge(17);

        studentDAO.save(student);
    }
}
