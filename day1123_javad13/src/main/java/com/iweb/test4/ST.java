package com.iweb.test4;

/**
 * 饿汉
 * 在类加载的时候，就完成了对象的初始化
 * 由于静态属性的特点，对象在类加载的时候就已经完成实例化了，所以线程安全
 *
 * @author Min
 * @date 2023/11/24 14:19
 */
public class ST {
    private static ST st = new ST();
    private ST(){

    }
    public static ST getSt(){
        return st;
    }
}
