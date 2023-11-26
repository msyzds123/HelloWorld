package com.iweb.classwork;

import lombok.Data;

/**
 * @author Min
 * @date 2023/11/21 0:27
 */
@Data
public class Monster {
    private String name;
    private float hp;
    //synchronized如果是修饰实例方法，同步对象就是当前对象this
    public synchronized void recover(){
        ++hp;
    }
    public  void hurt(){
        //同步对象由后面括号决定，可以是其他对象
        synchronized (this){
            --hp;
        }
    }
}
