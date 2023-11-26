package com.iweb.test2;

/**
 * @author Min
 * @date 2023/11/22 20:39
 */
public class Test {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        //定义任务线程
        for (int i = 0; i < 5; i++) {
            Runnable task = new Runnable(){
                public void run(){
                    System.out.println("任务线程");
                }
            };
            //将生成的任务添加到线程池的任务容器中
            pool.add(task);
            //延长主线程运行时间
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("运行结束");
        }
        //创建一个场景，假设任务运行需要1s的时间
        //开始的时候是间隔1s向线程池添加任务，然后不断减少投放任务的时间间隔
        //导致执行任务的线程还没结束，新的任务又来了
        int sleep = 1000;
        while (true){
            pool.add(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(sleep);
                sleep = sleep>100?sleep-100:100;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
