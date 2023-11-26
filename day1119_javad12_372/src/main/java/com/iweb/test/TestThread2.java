package com.iweb.test;

/**
 * join
 * main对应的主线程在一开始的时候一定是最先运行的
 * 只有主线程运行了，其他线程的对象才会被实例化，从而进入到就绪态
 * @author Min
 * @date 2023/11/20 21:32
 */
public class TestThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是t1");
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是t2");
                }
            }
        };
        t1.start();
        t2.start();
        try {
            //当执行到这一行前，一直是主线程在运行
            //当t1join之后，只有当t1线程的run方法运行完成之后，主线程才会继续进行
            t1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Thread t3 = new Thread(){
            public void run(){
                for (int i = 0; i < 10; i++) {
                    System.out.println("我是t3");
                }
            }
        };
        t3.start();
    }
}
