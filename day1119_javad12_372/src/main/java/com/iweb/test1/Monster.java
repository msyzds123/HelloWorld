package com.iweb.test1;

import lombok.Data;

/**
 * @author Min
 * @date 2023/11/21 0:27
 */
@Data
public class Monster {
    private String name;
    private float hp;

    // synchronized如果是修饰实例方法，同步对象就是当前对象this
    public  void recover() {
        synchronized (this){
            ++hp;
            System.out.println("为" + name + "恢复了一点生命值，当前生命值为" + hp);
            this.notify();
        }
    }

    public  void hurt() {
        synchronized (this){
            if (hp == 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            --hp;
            System.out.println("为" + name + "降低了一点生命值，当前生命值为" + hp);
        }

    }
}
