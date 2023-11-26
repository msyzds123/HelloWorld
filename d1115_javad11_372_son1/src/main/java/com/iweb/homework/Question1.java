package com.iweb.homework;

import org.junit.experimental.theories.DataPoint;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Min
 * @date 2023/11/14 22:43
 */
public class Question1 {
    public static HashMap<String,String> hashMap = new HashMap<>();
    public static void init(){
        for(int i = 0;i<5;i++){
            hashMap.put("user"+i,"12345");
        }
    }

    public static void logIn(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("输入用户名");
            String username = sc.nextLine();
            System.out.println("输入密码");
            String password = sc.nextLine();
            if(hashMap.get(username).equals(password)){
                System.out.println("登录成功");
                break;
            }else {
                System.out.println("输入错误，重新输入");
            }
        }

    }
    public static void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入用户名");
        String username = sc.nextLine();
        System.out.println("输入密码");
        String password = sc.nextLine();
        hashMap.put(username,password);
        System.out.println("注册成功");
    }
    public static void show(){
        for (String key:hashMap.keySet()) {
            System.out.printf("用户名为%s，密码为%s\n",key,hashMap.get(key));
        }
    }

    public static void main(String[] args) {
        init();
        logIn();
        register();
        show();
    }

}
