package com.iweb;

import com.iweb.DAO.StudentDAO;
import com.iweb.DAO.impl.StudentDAOimpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试
 * @author Min
 * @date 2023/11/15 20:24
 */
public class JDBCtest {
    private StudentDAO studentDAO;
    //在其他测试之前，被该注解修饰的方法会自动执行
    @Before
    public void init(){
        studentDAO = new StudentDAOimpl();
    }
    @Test
    public void testListAll(){
        System.out.println(studentDAO.listAll());
    }
    @Test
    public void testListAllWithGrade(){

        System.out.println(studentDAO.listAllWithGrade());
    }
    @After
    public void destroy(){
        System.out.println("处理");
    }
}
