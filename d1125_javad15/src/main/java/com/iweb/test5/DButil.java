package com.iweb.test5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Min
 * @date 2023/11/25 14:15
 */
@JDBCConfig(url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8",username = "root",password = "a12345")
public class DButil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        //获取当前贴在类上的注解对象
        //Field 成员变量的反射对象
        //Parameter 方法参数的反射对象
        JDBCConfig config = DButil.class.getAnnotation(JDBCConfig.class);
        String url = config.url();
        String username = config.username();
        String password = config.password();
        return DriverManager.getConnection(url,username,password);
    }

    public static void main(String[] args) throws Exception{
        System.out.println(getConnection());
    }
}
