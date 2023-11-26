package com.iweb.test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * java自带线程池
 * @author Min
 * @date 2023/11/23 16:04
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor
                (10,15,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1");
            }
        });
        showSeason(Season.SPRING);
    }
    public static void showSeason(Season season){
        switch (season){
            case SPRING:
                System.out.println("春");
                break;
            case SUMMER:
                System.out.println("夏");
                break;
            case AUTUMN:
                System.out.println("秋");
                break;
            case WINTER:
                System.out.println("冬");
                break;
            default:
                System.out.println("输入有误");
        }
    }
}
