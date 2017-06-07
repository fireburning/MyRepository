package com.test.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zhangxs on 2017/6/5.
 */
public class JDBCUtilTest {

    @Test
    public void testGetConnection() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }

}
