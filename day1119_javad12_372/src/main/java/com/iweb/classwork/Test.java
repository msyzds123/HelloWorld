package com.iweb.classwork;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Min
 * @date 2023/11/21 0:31
 */
public class Test {
    public static void main(String[] args)  {
        final Monster goblins = new Monster();
        goblins.setName("哥布林");
        goblins.setHp(10000);
        int n = 10000;
        List<Thread> addThreads = new ArrayList<>();
        List<Thread> reduceThreads = new ArrayList<>();
        //定义一万个负责调用recover方法给哥布林回血的线程
        for (int i = 0; i < n ; i++) {
            Thread t = new Thread(){
                public void run(){
                    goblins.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            //将线程加入到主线程
            addThreads.add(t);
        }
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                public void run(){
                    goblins.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads.add(t);
        }
        //最终要在主线程中访问哥布林的血量，所以必须保证主线程会等待2w个线程跑完之后，再继续进行读取血量
        //所以要将2w个线程join主线程
        for(Thread t:addThreads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(Thread t:reduceThreads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("hp"+goblins.getHp());
    }
}
