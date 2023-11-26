package com.iweb.homework;

import java.util.Random;

/**
 * @author Min
 * @date 2023/11/21 18:29
 */
public class Question3 {
    public static String stringPool(){
        Random r = new Random();
        String stringPool = "1234567890qwertyuiopasdfghjklzxcvbnm";
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int j = r.nextInt(stringPool.length());
            s.append(stringPool.charAt(j));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        final String s = stringPool();
        System.out.println("密码为"+s);
        final StringBuilder sb = new StringBuilder();
        Thread crack = new Thread(){
            @Override
            public void run(){
                boolean flag = true;
                while (flag){
                    String t = stringPool();
                    sb.append(t);
                    if(t.equals(s)){
                        flag = false;
                    }
                }
                System.out.println("破解成功");
            }
        };
        Thread log = new Thread(){
            @Override
            public void run(){
                while (sb.length()!=0){
                    System.out.println("猜测密码"+sb.substring(sb.length()-3));
                    sb.delete(sb.length()-3,sb.length()-1);
                }
            }
        };
        log.setDaemon(true);
        crack.start();
        log.start();
        try {
            crack.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
