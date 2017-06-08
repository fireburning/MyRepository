package com.test.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * Created by zhangxs on 2017/6/6.
 */
public class DataSourceTest {

    private ApplicationContext ctx = null;

    @Before
    public void steup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("steup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testDataSource(){
        DataSource dataSource = (DataSource)ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
        System.out.println("testDataSource");
    }

    @Test
    public void testJdbcTemplate(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);
        System.out.println("testJdbcTemplate");
    }
}
