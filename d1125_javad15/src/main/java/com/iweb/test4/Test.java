package com.iweb.test4;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Min
 * @date 2023/11/25 11:18
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(DButil.getDataSource());
    }
}
