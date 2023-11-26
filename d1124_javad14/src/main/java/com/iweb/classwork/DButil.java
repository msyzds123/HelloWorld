package com.iweb.classwork;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Min
 * @date 2023/11/24 16:15
 */
public class DButil {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "a12345";
    private static final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
    static {
        try {
            // 驱动加载
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()throws Exception{
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
