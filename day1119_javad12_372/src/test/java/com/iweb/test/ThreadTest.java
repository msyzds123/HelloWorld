package com.iweb.test;

import org.junit.Test;

/**
 * @author Min
 * @date 2023/11/20 20:20
 */
public class ThreadTest {
    @Test
    public void threadTest1(){
        //实例化线程对象
        FightRIce fr1 = new FightRIce("msy");
        FightRIce fr2 = new FightRIce("zyx");
        FightRIce fr3 = new FightRIce("wjc");
        //线程的职责是运行完成自己的run方法
        //线程需要调用start方法使自己进入到就绪态
        //进入到就绪态的线程才会有机会被jvm进行调度
        //单位时间内，只会有一个进程被jvm调度
        //jvm选择哪一个进程运行，运行多长时间，是程序员不可控的
        //哪一个线程先被执行，和start顺序无关，也和线程对象的创建时间无关，只和jvm有关
        fr1.start();
        fr2.start();
        fr3.start();
    }

}
