package com.herench;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * com.herench
 *
 * @author zhiwei
 * @create 2016-12-14 16:37.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://192.168.11.17:1433;DatabaseName=xqjxpt", "sa", "`1q");
        System.out.println(connection);
    }

}
