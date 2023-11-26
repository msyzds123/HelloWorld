package com.iweb.test;

/**
 * 多线程
 * 1.继承Thread类
 * 2.实现Runnable接口
 * 3.实现Callable接口
 * 4.实现Future接口
 * @author Min
 * @date 2023/11/20 19:54
 */
public class TestThread {
    public static void main(String[] args) {
        // 通过Runnable接口完成线程对象实例化的时候，需借助Thread类完成实例化
        // FuckRice fr1 = new FuckRice();
        // Thread t1 = new Thread(fr1);
        // FuckRice fr2 = new FuckRice();
        // Thread t2 = new Thread(fr2);
        // t1.setName("zyx");
        // t2.setName("msy");
        // t1.start();
        // t2.start();
        //匿名内部类，本质是内部类的一种，只不过开发者不需要提供类的名称，类名
        //由jvm动态分配
        Thread t1 = new Thread(){
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println("你是"+this.getName());
                }
            }
        };
        t1.setName("sxl");
        Thread t2 = new Thread(){
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println("我不是"+this.getName());
                }
            }
        };
        t2.setName("lyh");
        t1.start();
        t2.start();
        System.out.println(t1.getClass().getName());
        System.out.println(t2.getClass().getName());
    }
}
