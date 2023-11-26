package com.iweb.test;

import com.iweb.DAO.StudentDAO;
import com.iweb.DAO.impl.GradeDAOimpl;
import com.iweb.DAO.impl.StudentDAOimpl;
import com.iweb.entity.Grade;
import com.iweb.entity.Student;

import java.util.Date;

/**
 * ORM object relation model 对象映射关系模型
 *
 * @author Min
 * @date 2023/11/14 18:32
 */
public class TestJDBC {
    // public static void main(String[] args) throws Exception {
    //     try(Connection c= DButil.getConnection();
    //         Statement s =c.createStatement()) {
    //         String sql = "INSERT INTO student(NAME,gender,birthday,address,qqnumber)\n"+
    //                 "VALUES('朱燕nan','男','2002-2-23','常州',2298890352)";
    //         s.execute(sql);
    //     }catch (SQLException e)
    //     {
    //         e.printStackTrace();
    //     }
     public static void main(String[] args) {
         //     StudentDAO studentDAO = new StudentDAOimpl();
         //     studentDAO.delete(7);
         // }

         Student s = new Student();
         s.setName("zyx");
         s.setAddress("无锡");
         s.setGender("女");
         s.setQqnumber(129);
         s.setBirthday(new Date());
         s.setId(1);
         StudentDAO studentDAO = new StudentDAOimpl();
         // studentDAO.insert(s);
         //studentDAO.update(s);
         //System.out.println(studentDAO.listByPage("李",0,3));
         //System.out.println(studentDAO.listByNameLike("李"));
         //studentDAO.testInsert();
         GradeDAOimpl gradeDAOimpl = new GradeDAOimpl();
         // gradeDAOimpl.createGrade();
         // Grade g1 = new Grade();
         // g1.setSubject("美术");
         // g1.setSid(1);
         // g1.setScore(88.88);
         // gradeDAOimpl.insert(g1);
         System.out.println(studentDAO.listByIdWithGrade(1));
         System.out.println(gradeDAOimpl.listBySid(1));
     }


}