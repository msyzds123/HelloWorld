package com.iweb.test;

/**
 * @author Min
 * @date 2023/11/22 18:28
 */
public class Test {
    // 静态方法的同步对象是当前类的class对象
    public synchronized static void li() {

    }
    // 等价写法
    // 每个类的反射对象全局唯一
    public static void l() {
        synchronized (Test.class) {

        }
    }



    public static void main(String[] args) {

    }
}
