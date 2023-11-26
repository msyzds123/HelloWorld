package com.iweb.test;

/**
 * 实现runnable接口
 * @author Min
 * @date 2023/11/20 20:32
 */
public class FuckRice implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是"+Thread.currentThread().getName());
        }
    }
}
