package com.iweb.test1;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 在反射的思想中，万物皆可以是对象
 * 构造方法，方法，成员变量等都可以当作对象使用
 * 但是必须通过类对象进行获取
 * 配置优于实现，约定优于配置
 *
 * @author Min
 * @date 2023/11/25 9:16
 */
public class Test {
    // 设计一个方法，能够根据配置文件中所记录的信息创建一个Person接口的子类对象，并且使用对象调用eat方法
    // 在代码不改变的情况下，修改配置文件，达到调用不同eat方法的目的
    public static Person getInstance() {
        File f = new File("D:\\idea_workspace\\day1115_javad11\\d1125_javad15\\src\\main\\java\\com\\iweb\\test1\\person.config");
        StringBuilder sb = new StringBuilder();
        Person p = null;
        try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)) {
            String line = br.readLine();
            String className = line.substring(line.indexOf("="));
            Class c = Class.forName(className);
            Constructor<Person> cc = c.getConstructor();
            p = cc.newInstance();
            p.eat();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        // Class c1 = Class.forName("com.iweb.test1.Student");
        // 根据类对象获取对应的构造器对象(获取的是无参构造方法的反射对象)
        // Constructor<Student> c = c1.getConstructor();
        // 利用无参构造方法完成对象的实例化
        // Student s = c.newInstance();
        // 查看对象属性
        // System.out.println(s);
        // 获取有参构造函数的反射对象
        // Constructor<Student> c2 = c1.getConstructor(String.class);
        // 利用有参构造函数完成对象的创建
        // Student s1 = c2.newInstance("msy");
        // System.out.println(s1);
        getInstance();
    }
}
