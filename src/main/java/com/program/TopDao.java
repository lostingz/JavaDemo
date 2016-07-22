/**
 * Chsi
 * Created on 2016年7月22日
 */
package com.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class TopDao {
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

    public static Connection getConnection() throws SQLException {
        if (connectionThreadLocal.get() == null) {
            Connection conn = DriverManager.getConnection("url");
            connectionThreadLocal.set(conn);
        }
        return connectionThreadLocal.get();
    }
}
