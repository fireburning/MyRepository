package com.test.util;

import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zhang on 2017/6/5.
 */
public class JDBCUtilTest {

    @Test
    public void testGetConnection() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}
