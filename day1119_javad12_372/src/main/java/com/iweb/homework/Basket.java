package com.iweb.homework;

/**
 * @author Min
 * @date 2023/11/21 17:33
 */
public class Basket {
    static int eggCount = 0;
    static int capacity = 10;

    public synchronized void layEggs() {
        while (true) {
            if (Basket.eggCount < Basket.capacity) {
                eggCount++;
                System.out.println("下一个蛋，剩下" + Basket.eggCount);
                notifyAll();
            } else {
                System.out.printf("篮子满了，停止下蛋");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void pickEggs() {
        while (true) {
            if (Basket.eggCount > 0) {
                eggCount--;
                System.out.println("偷走一个蛋，剩下" + Basket.eggCount);
                notifyAll();
            } else {
                System.out.printf("篮子里没蛋了\n");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main(String[] args) {
        final Basket b = new Basket();
        Thread kun = new Thread() {
            public void run() {
                b.layEggs();
            }

        };
        kun.start();
        for (int i = 0; i < 10; i++) {
            Thread d = new Thread() {
                @Override
                public void run() {
                    b.pickEggs();
                }

            };
            d.start();
        }
    }
}
