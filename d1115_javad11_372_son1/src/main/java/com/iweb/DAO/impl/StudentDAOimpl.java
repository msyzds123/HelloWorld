package com.iweb.DAO.impl;

import com.iweb.DAO.GradeDAO;
import com.iweb.DAO.StudentDAO;
import com.iweb.entity.Grade;
import com.iweb.entity.Student;
import com.iweb.test.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Min
 * @date 2023/11/14 20:04
 */
public class StudentDAOimpl implements StudentDAO {
    private static GradeDAOimpl gradeDAO = new GradeDAOimpl();
    @Override
    public void insert(Student stu) {
        // String sql = "INSERT INTO student(NAME,gender,birthday,address,qqnumber) values('"
        //         +stu.getName()+"',"+"'"+stu.getGender()+"',"+stu.getBirthday()+"',"+stu.getAddress()+"',"+stu.getQqnumber()+")";
        // try(Connection c = DButil.getConnection();
        //     Statement s = c.createStatement();
        // ){
        //     s.execute(sql);
        // }catch (Exception e){
        //     e.printStackTrace();
        // }
        // statement存在几种弊端
        // 1.参数较多的时候，拼接麻烦
        // 2.statement是先传参再编译，性能较差
        // 3.statement存在sql注入的问题
        // PrepareStatement
        // 1.参数传递简单，方法调用传递即可
        // 2.先编译，再传参，性能更好
        // 3.不存在sql注入攻击的问题，在参数传入之前，语句已经编译确定了
        // 传递的参数只会被当作是字符串识别
        // 使用方法进行传参，用序号代表所传递参数问号的位置，为数不多基数为1的参数传递
        String sql = "INSERT INTO student(NAME,gender,birthday,address,qqnumber)" + "values(?,?,?,?,?)";
        try (Connection c = DButil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, stu.getName());
            ps.setString(2, stu.getGender());
            ps.setDate(3, new Date(stu.getBirthday().getTime()));
            ps.setString(4, stu.getAddress());
            ps.setLong(5, stu.getQqnumber());
            ps.execute();
            // 在执行完插入语句之后，mysql会为新增的数据分配一个自增长id
            // 而jbdc可以通过getGenneratedKeys方法获取id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                stu.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    // 由于没有写 c.setAutoCommit(false);,所有的dml语句都是默认自动commit,不需要进行事务管理
    // 如果写了，需要在方法的最后手动调用c.commit()在提交

    @Override
    public void delete(Integer id) {
        String sql = "delete from student where id = " + id;
        try (Connection c = DButil.getConnection();
             Statement s = c.createStatement();
        ) {
            s.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student stu) {
        String sql = "update Student set name = ?,gender = ?,birthday = ?,address = ?,qqnumber = ? where id = ?";
        try (Connection c = DButil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setString(1, stu.getName());
            ps.setString(2, stu.getGender());
            ps.setDate(3, new Date(stu.getBirthday().getTime()));
            ps.setString(4, stu.getAddress());
            ps.setLong(5, stu.getQqnumber());
            ps.setInt(6, stu.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Student> listAll() {
        return listByPage(null, 0, Integer.MAX_VALUE);
    }

    @Override
    public List<Student> listByNameLike(String key) {
        List<Student> ls = new ArrayList<>();
        String sql = "select * from student where name like concat('%',?,'%')";
        try (Connection c = DButil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getString("gender"));
                s.setBirthday(rs.getDate("birthday"));
                s.setAddress(rs.getString("address"));
                s.setQqnumber(rs.getInt("qqnumber"));
                ls.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return ls.isEmpty() ? null : ls;
    }

    @Override
    public List<Student> listByPage(Integer start, Integer count) {
        return listByPage(null, start, count);
    }

    @Override
    public List<Student> listByPage(String key, Integer start, Integer count) {
        List<Student> ls = new ArrayList<>();
        String sql;
        if (key == null || key == "") {
            sql = "select * from student limit ?,?";
        } else {
            sql = "select * from student where name like concat('%',?,'%')limit ?,?";
        }
        try (Connection c = DButil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            if (key == null || key == "") {
                ps.setInt(1, start);
                ps.setInt(2, count);
            } else {
                ps.setString(1, key);
                ps.setInt(2, start);
                ps.setInt(3, count);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                // 从结果集遍历的当前行中.将每一个字段的值单独取出
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                long qqnumber = rs.getLong("qqnumber");
                s.setId(id);
                s.setName(name);
                s.setGender(gender);
                s.setBirthday(birthday);
                s.setAddress(address);
                s.setQqnumber(qqnumber);
                ls.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls.isEmpty() ? null : ls;
    }

    public void testInsert() {
        String sql = "insert into student values(?,?,?,?,?,?)";
        Connection c = null;
        try {
            c = DButil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 关闭事务自动提交
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            c.setAutoCommit(false);
            Random r = new Random();
            for (int i = 0; i < 10000; i++) {
                ps.setInt(1, r.nextInt(200) + 10);
                ps.setString(2, "学生" + i);
                ps.setString(3, "男");
                ps.setDate(4, new Date(new java.util.Date().getTime()));
                ps.setString(5, "南京");
                ps.setLong(6, r.nextInt(1000000) + 10000);
                ps.execute();
            }
            c.commit();
        } catch (Exception e) {
            try {
                System.out.println("插入错误，事务回滚");
                c.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public Student listByIdWithGrade(Integer sid) {
        Student s = null;
        String sql = "select * from student where id = ?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ){
            ps.setInt(1,sid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));;
                s.setGender(rs.getString("gender"));
                s.setBirthday( rs.getDate("birthday"));
                s.setAddress( rs.getString("address"));
                s.setQqnumber(rs.getLong("qqnumber"));
                s.setGrades(gradeDAO.listBySid(sid));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public List<Student> listAllWithGrade(int start, int count) {
        List<Student> ls = new ArrayList<>();
        String sql = "select * from student limit ?,?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student s = null;
                int id = rs.getInt("id");
                s = listByIdWithGrade(id);
                ls.add(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ls.isEmpty()?null:ls;
    }

    @Override
    public List<Student> listAllWithGrade() {
        return listAllWithGrade(0,Integer.MAX_VALUE);
    }
}
