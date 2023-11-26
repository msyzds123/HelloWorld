package com.iweb.test;

/**
 * @author Min
 * @date 2023/11/20 20:13
 */
public class FightRIce extends Thread{
    public FightRIce(String name){
        super(name);
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("饿了吃饭"+this.getName());
        }
    }
}
