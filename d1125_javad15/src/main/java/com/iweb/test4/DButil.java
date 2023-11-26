package com.iweb.test4;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Min
 * @date 2023/11/25 11:48
 */
public class DButil {
    private static DataSource dataSource;
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\idea_workspace\\day1115_javad11\\d1125_javad15\\src\\main\\java\\com\\iweb\\test4\\db.properties"));
            Class dClass = DataSource.class;
            Constructor<DataSource> c1 = dClass.getConstructor();
            dataSource = c1.newInstance();
            //获取DataSource的set方法
            Method m = dClass.getMethod("setConnection", Connection.class);
            Class.forName("com.mysql.jdbc.Driver");
            //利用配置文件，读取信息获取连接对象
            Connection c = DriverManager.getConnection((String) properties.get("url"),(String) properties.get("username"),(String) properties.get("password"));
            m.invoke(dataSource,c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
