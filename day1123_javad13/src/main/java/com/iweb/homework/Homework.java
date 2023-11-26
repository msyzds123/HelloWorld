package com.iweb.homework;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Min
 * @date 2023/11/24 9:13
 */
public class Homework {
    volatile boolean flag = true;
    volatile int   a = 0;
    AtomicInteger i = new AtomicInteger(0);
    Lock lock = new ReentrantLock();
    public  void add(){
        // lock.lock();
        // ++a;
        // System.out.println("操作自增完成，a="+a);
        // lock.unlock();
        i.getAndIncrement();

    }
    public  void sub(){
        // lock.lock();
        // --a;
        // System.out.println("操作自减完成，a="+a);
        // lock.unlock();
        i.decrementAndGet();
    }

    public static void main(String[] args) {
        Homework h = new Homework();
        for (int i = 0; i < 500; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    h.add();
                }
            };
            t.start();
            Thread ts = new Thread(){
                @Override
                public void run() {
                    h.sub();
                }
            };
            ts.start();
            try {
                t.join();
                ts.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        System.out.println("i的值"+h.i);
    }
}
