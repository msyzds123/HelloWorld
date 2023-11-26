package com.iweb.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Min
 * @date 2023/11/14 23:05
 */
public class Question2 {
    int n ;
    static List<Integer> l = new ArrayList<>();
    public static void init(){
        int n = 10;
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int price = r.nextInt(100);
            l.add(price);
        }

    }
    public static void show(){
        Collections.sort(l);
        System.out.println(l);
        System.out.println(l.get(2));;
        }

    public static void main(String[] args) {
        init();
        show();
    }

}
