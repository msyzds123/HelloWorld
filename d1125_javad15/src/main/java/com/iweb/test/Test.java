package com.iweb.test;

/**
 * 反射和注释
 * 将java的类当作是一种对象，类对象
 * @author Min
 * @date 2023/11/25 9:04
 */
public class Test {
    static {
        System.out.println("静态属性被加载");
    }
    public static void main(String[] args) throws Exception {
        //三种方式获取类对象
        //1.调用class.forName获取
        Class c1 = Class.forName("com.iweb.test.Test");
        //2.利用类对象多对应的类的实例获取
        Class c2 = new Test().getClass();
        //使用.class直接获取,不会加载类的静态属性
        Class c3 = Test.class;
        //类对象在同一个jvm中，不管获取多少次，获取的都是同一个
        //类加载只会进行一次，而类对象会在类加载的时候自动创建
        // System.out.println(c1 == c2);
        // System.out.println(c1 == c3);
        //类对象你获取的时候会自动加载对应类的静态属性
    }
}
