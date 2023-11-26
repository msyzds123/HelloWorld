package com.iweb.test1;

/**
 * @author Min
 * @date 2023/11/25 9:15
 */
public class Student implements Person{
    String name;

    public Student(String name) {
        this.name = name;
    }
    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
