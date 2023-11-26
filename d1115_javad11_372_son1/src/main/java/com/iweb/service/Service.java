package com.iweb.service;

import com.iweb.entity.User;
import com.iweb.test.DButil;
import com.iweb.util.UserData;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Min
 * @date 2023/11/13 22:35
 */
public class Service {
    public static boolean login(User inputUser) {
        boolean flag = true;
        String name = inputUser.getUserName();
        String password = inputUser.getUserPassword();
        String sql = "select userPassword from userdata where userName = ?";
        try (
                Connection c = DButil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (password == rs.getString("userPassword")) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public static boolean register(User inputUser) {
        boolean flag = false;
        String sql = "insert into userdata(userName,userPassword) value(?,?) ";
        try (
                Connection c = DButil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, inputUser.getUserName());
            ps.setString(2, inputUser.getUserPassword());
            ps.execute();
            // 在执行完插入语句之后，mysql会为新增的数据分配一个自增长id
            // 而jbdc可以通过getGenneratedKeys方法获取id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inputUser.setId(rs.getInt(1));
            }
            flag = true ;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}
