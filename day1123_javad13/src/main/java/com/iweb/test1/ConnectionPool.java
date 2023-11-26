package com.iweb.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Min
 * @date 2023/11/23 16:34
 */
public class ConnectionPool {
    //定义集合保存数据库连接
    List<Connection>cs = new ArrayList<>();
    //定义连接池大学
    int size ;
    public ConnectionPool(int size){
        this.size = size;
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void init() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        for (int i = 0; i < size; i++) {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8","root","a12345");
            cs.add(c);
        }
    }
    public synchronized Connection getConnection(){
        while (cs.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection c = cs.remove(0);
        return c;
    }
    public synchronized void returnConnection(Connection c){
        cs.add(c);
        this.notifyAll();
    }
}
