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
 * Created by zhangxs on 2017/6/5.
 */
public class StudentDAOSpringJdbcImplTest {

    private ApplicationContext ctx = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }
    @Test
    public void testQuery() throws SQLException, ClassNotFoundException, IOException {
        StudentDAO studentDAO = (StudentDAO) ctx.getBean("studentDAO");
        List<Student> students= studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + " ,name:" + student.getName()
                    + " ,age:" +student.getAge());
        }
    }

    @Test
    public void testSave() throws SQLException, ClassNotFoundException, IOException {
        StudentDAO studentDAO = (StudentDAO) ctx.getBean("studentDAO");
        Student student = new Student();
        student.setName("test-spring-jdbc");
        student.setAge(30);
        studentDAO.save(student);
    }

}
