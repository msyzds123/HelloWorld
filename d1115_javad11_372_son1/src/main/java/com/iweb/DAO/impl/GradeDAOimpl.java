package com.iweb.DAO.impl;

import com.iweb.DAO.GradeDAO;
import com.iweb.entity.Grade;
import com.iweb.test.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Min
 * @date 2023/11/15 18:30
 */
public class GradeDAOimpl implements GradeDAO {
    @Override
    public  List<Grade> listBySid(Integer id) {
        List<Grade> lg = new ArrayList<>();
        String sql = "select * from grade where sid = ?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Grade g = new Grade();
                g.setId(rs.getInt("id"));
                g.setSubject(rs.getString("subject"));
                g.setScore(rs.getDouble("score"));
                g.setSid(rs.getInt("sid"));
                lg.add(g);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lg.isEmpty()?null:lg;
    }

    @Override
    public void createGrade() {
        String sql = "create table Grade(id int,subject varchar(200), score double, sid int)";
        try(Connection c = DButil.getConnection();
            Statement s = c.createStatement();
        ){
            s.execute(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Grade g) {
        String sql = "INSERT INTO grade(subject,score,sid)" + "values(?,?,?)";
        try (Connection c = DButil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1,g.getSubject());
            ps.setDouble(2, g.getScore());
            ps.setInt(3, g.getSid());
            ps.execute();
            // 在执行完插入语句之后，mysql会为新增的数据分配一个自增长id
            // 而jbdc可以通过getGenneratedKeys方法获取id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                g.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
