package com.iweb.test;

/**
 * 死锁
 * @author Min
 * @date 2023/11/21 10:13
 */
public class Test2 {
    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                synchronized (o1){
                    System.out.println("t1获取了o1锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1试图获取o2的锁");
                    System.out.println("t1被阻塞");
                    synchronized (o2){
                        System.out.println("t1获取到了o2的锁");
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run(){
                synchronized (o2){
                    System.out.println("t2获取了o2锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2试图获取o1的锁");
                    System.out.println("t2被阻塞");
                    synchronized (o1){
                        System.out.println("t2获取到了o1的锁");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
