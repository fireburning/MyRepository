package com.test.repository;

import com.test.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhang on 2017/6/7.
 */
public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFindByName(){
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println("id:" + employee.getId()
                + " ,name:" + employee.getName()
                + " ,age:" + employee.getAge());
    }
}
