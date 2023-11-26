package com.iweb.test1;

/**
 * 线程交互 wait notify notifyall 同步对象的方法（Object）
 * 三个方法必须出现在同步代码块中
 *
 * wait方法 让占有当前同步对象锁的线程进入到等待状态，临时释放锁
 * 直到同步对象调用了notify或者notifyall方法，线程在重新获得锁的前提下，从wait继续运行
 * 默认情况下，处于wait状态的线程，如果同步对象没有调用notify方法去唤醒，就会一直处于wait状态
 *
 * notify方法，没一个同步对象都会有一个等待列表，记录的是被其所wait的线程是哪些
 * 作用是从当前同步对象的等来列表中选择一个线程尽心唤醒
 *
 * notify方法唤醒同步对象等待列表中的所有处于wait状态下的线程
 * @author Min
 * @date 2023/11/21 10:27
 */
public class Test {
    public static void main(String[] args) {
        final Monster goblin =new Monster();
        goblin.setName("哥布林");
        goblin.setHp(500);
        Thread t1 = new Thread(){
            @Override
            public void run(){
                while (true){
                    goblin.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        Thread t2 = new Thread(){
            public void run(){
                while (true){
                    goblin.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
