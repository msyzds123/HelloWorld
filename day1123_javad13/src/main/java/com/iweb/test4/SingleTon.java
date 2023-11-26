package com.iweb.test4;

/**
 * 懒汉模式（延迟加载）
 * 如果保证了线程安全，会导致性能下降
 * @author Min
 * @date 2023/11/24 14:11
 */
public class SingleTon {
    private static SingleTon singleTon;
    private SingleTon(){

    }
    public static synchronized SingleTon getSingleTon(){
        if(singleTon == null){
            singleTon = new SingleTon();
        }
        return singleTon;
    }
}
