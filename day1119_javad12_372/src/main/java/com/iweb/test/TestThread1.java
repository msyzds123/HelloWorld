package com.iweb.test;

/**
 * 线程的休眠 sleep
 * 会使当前线程暂停运行并且放弃jvm的调度资源
 * 其他线程可以在该线程sleep期间内获取jvm的调度
 * 线程可以指定sleep时间，时间到了之后线程会恢复
 * @author Min
 * @date 2023/11/20 21:14
 */
public class TestThread1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            public void run(){
                int times = 0;
                while (true){
                    System.out.println("开始休眠");
                    try{
                        Thread.sleep(1);
                        System.out.println("醒来");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    times += 1;
                    System.out.println("线程已经运行的时间"+times);
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                while (true){
                    System.out.println("t2抢到了调度资源");
                }
            }
        };
        t1.start();
        t2.start();
    }
}
