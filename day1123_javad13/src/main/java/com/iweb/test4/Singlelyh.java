package com.iweb.test4;

/**
 * 双重检查锁的单例模式
 * @author Min
 * @date 2023/11/24 14:28
 */
public class Singlelyh {
    private volatile static Singlelyh singlelyh;
    private Singlelyh(){

    }
    public static Singlelyh getInstance(){
        //为了提高性能，如果其他线程发现对象已经被实例化
        //则通过return直接获取对象的引用，而不需要再获取锁了
        if(singlelyh == null){
            synchronized (Singlelyh.class){
                if(singlelyh == null){
                    singlelyh = new Singlelyh();
                }
            }
        }
        return singlelyh;
    }
}
