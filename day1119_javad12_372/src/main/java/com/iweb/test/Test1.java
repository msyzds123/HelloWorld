package com.iweb.test;

/**
 * @author Min
 * @date 2023/11/21 10:01
 */
public class Test1 {
    public static void main(String[] args) {
        //定义一个同步对象，用来提供锁
        final Object o = new Object();
        Thread t1 = new Thread(){
            public void run(){
                System.out.println("t1运行");
                System.out.println("t1试图获取o对象锁");
                synchronized (o){
                    System.out.println("t1获取到了o对象锁");
                    try {
                        //线程在sleep的时候不会释放锁
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1释放锁");
                }
                System.out.println("t1运行结束");
            }

        };
        Thread t2 = new Thread(){
            public void run(){
                System.out.println("t2运行");
                System.out.println("t2试图获取o对象锁");
                synchronized (o){
                    System.out.println("t2获取到了o对象锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2释放锁");
                }
                System.out.println("t2运行结束");
            }

        };
        t1.start();
        t2.start();
    }
}
