package com.test.dao;


import com.test.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by zhang on 2017/6/6.
 */
public class StudentDAOSpringJdbcImplTest {

    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDAO = (StudentDAO)ctx.getBean("studentDAO");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testQuery() throws SQLException, IOException, ClassNotFoundException {

        List<Student> students = studentDAO.query();
        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + " ,name:" + student.getName()
                    + " ,age:" + student.getAge());
        }
    }

    @Test
    public void testSave() throws SQLException, IOException, ClassNotFoundException {

        Student student = new Student();
        student.setName("test-spring-jdbc");
        student.setAge(20);

        studentDAO.save(student);
    }
}