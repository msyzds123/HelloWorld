package com.iweb.test1;

/**
 * 生产者消费者是一个经典的多线程设计模式
 * 通常有两类线程，其中有若干个生产者线程和若干个消费者线程
 * 生产者线程负责生成用户请求，消费者线程负责处理用户请求
 * @author Min
 * @date 2023/11/22 18:34
 */
public class Test {
    public static void main(String[] args) {
        Basket bt = new Basket();
        Producer p = new Producer(bt);
        Comsumer c = new Comsumer(bt);
        //启动
        new Thread(p).start();
        //给生产者足够的时间装馒头
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(c).start();

    }
}
