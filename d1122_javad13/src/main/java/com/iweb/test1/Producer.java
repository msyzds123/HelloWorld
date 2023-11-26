package com.iweb.test1;

/**
 * 生产者负责生产馒头，如果生产者线程有多个，必须保证操纵的篮子是同一个
 * @author Min
 * @date 2023/11/22 18:55
 */
public class Producer implements Runnable{
    Basket bt;
    Producer(Basket bt){
        this.bt = bt;
    }
    public void run() {
        //假设一个生产者放20个馒头
        for (int i = 0; i < 20; i++) {
            ManTou mt = new ManTou();
            bt.push(mt);
            System.out.println("生产者生产了馒头");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
