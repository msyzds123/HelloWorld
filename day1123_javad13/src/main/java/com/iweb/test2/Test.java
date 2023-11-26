package com.iweb.test2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步悲观锁的另一种实现方式 Reentrantlock
 * 锁的获取和释放是通过方法调用来实现的
 * 使用synchronized ()进行线程调度，使用的是wait，notify，notifyAll方法
 * lock提供了类似的方法，先通过lock对象获取一个Condition对象
 * 调用该对象的await，signal，signalAll方法
 * Reentrantlock和synchronized 的区别：
 * 1.lock本质是一个接口，是代码层面的实现，而synchronized 是java中的关键字，内置语言的实现
 * 2.lock可以选择性的获取锁，如果一段时间内获取不到，就会放弃，所以可以利用 trylock的特性有效避免死锁，synchronized 必须通过设计才能避免死锁
 * 3.synchronized在发生异常或者让同步代码块运行结束的时候会自动释放锁，而lock接口必须通过调用unlock方法手动释放
 *
 * 原子操作  不可以被线程打断的操作
 * AtomicInteger ai = new AtomicInteger();
 * ConcurrentHashMap chm = new ConcurrentHashMap();
 * java中提供了一些原子类，原子类的所有操作都是线程安全的（具有原子性）
 * HashTable 保证线程安全保证使用的是synchronized关键字，悲观锁
 * ConcurrentHashMap在jdk1.7使用的是分段锁Segment， 在jdk1.8使用的是自旋锁,乐观锁
 * 本质是一个死循环，一直尝试获取锁，如果获取锁的时候，锁被其他线程所持有，通过循环在下一次继续尝试获取，可以有效避免阻塞
 * @author Min
 * @date 2023/11/23 18:10
 */
public class Test {
    private static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
    private static void log(String msg){
        System.out.printf("%s  %s  %S  %n",now(),Thread.currentThread().getName(),msg);
    }
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        // Thread t1 = new Thread(){
        //    public void run(){
        //        log("线程启动");
        //        lock.lock();
        //        log("获取到对象锁");
        //        log("模拟5s的业务操作");
        //        try {
        //            Thread.sleep(5000);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }finally {
        //            log("释放锁");
        //            lock.unlock();
        //        }
        //        log("线程运行结束");
        //    }
        // };
        // Thread t2 = new Thread(){
        //     public void run(){
        //         log("线程启动");
        //         lock.lock();
        //         log("获取到对象锁");
        //         log("模拟5s的业务操作");
        //         try {
        //             Thread.sleep(5000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //         log("线程运行结束");
        //     }
        // };
        // t1.setName("t1");
        // t1.start();
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // t2.setName("t2");
        // t2.start();
        // Condition condition = lock.newCondition();
        // Thread t1 = new Thread(){
        //     public void run(){
        //         try {
        //             log("线程启动");
        //             log("尝试获取锁");
        //             lock.lock();
        //             log("成功获取到锁");
        //             Thread.sleep(5000);
        //             log("使用wait方法临时释放锁，并进入到等待状态");
        //             condition.await();
        //             log("重新获取锁，并且再进行5s的模拟业务操作");
        //             Thread.sleep(5000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //         log("线程结束");
        //     }
        // };
        // Thread t2 = new Thread(){
        //     public void run(){
        //         try{
        //             log("线程启动");
        //             log("试图获取锁");
        //             lock.lock();
        //             log("获取到锁");
        //             log("5s业务操作");
        //             Thread.sleep(5000);
        //             log("唤醒处于wait的锁");
        //             condition.signal();
        //         }catch (InterruptedException e){
        //             e.printStackTrace();
        //         }finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //     }
        // };
        // t1.setName("t1");
        // t1.start();
        // t2.setName("t2");
        // t2.start();
        Thread t1 = new Thread(){
            boolean locked = false;
            @Override
            public void run() {
                try {
                    log("线程启动");
                    log("试图获取锁");
                    //线程会尝试获取锁，但是只获取1s
                    //如果获取不到，返回false，并且放弃获取，直接执行后续代码
                    locked = lock.tryLock(1, TimeUnit.SECONDS);
                    if(locked){
                        log("成功获取到锁");
                        log("业务进行");
                        Thread.sleep(5000);
                    }else {
                        log("经过1s尝试，没有获取到锁");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if(locked){
                        log("释放锁");
                        lock.unlock();
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            boolean locked = false;
            @Override
            public void run() {
                try {
                    log("线程启动");
                    log("试图获取锁");
                    //线程会尝试获取锁，但是只获取1s
                    //如果获取不到，返回false，并且放弃获取，直接执行后续代码
                    locked = lock.tryLock(1, TimeUnit.SECONDS);
                    if(locked){
                        log("成功获取到锁");
                        log("业务进行");
                        Thread.sleep(5000);
                    }else {
                        log("经过1s尝试，没有获取到锁");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if(locked){
                        log("释放锁");
                        lock.unlock();
                    }
                }
            }
        };
        t1.setName("t1");
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.setName("t2");
        t2.start();
    }
}
