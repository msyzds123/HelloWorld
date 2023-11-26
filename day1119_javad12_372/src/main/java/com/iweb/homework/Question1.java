package com.iweb.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Min
 * @date 2023/11/21 14:38
 */
public class Question1 {
    private List<Integer> li = new ArrayList<>(20);
    int size = 0;

    public synchronized void add() {
        while (true) {
            Random r = new Random();
            if (size == 20) {
                try {
                    System.out.println("数组已满");
                    System.out.print(li + "  ");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                int a = r.nextInt(100);
                li.add(a);
                System.out.println("向数组中差入数据" + a);
                size++;
                this.notifyAll();
            }
        }
    }

    public synchronized void remove() {
        while (true) {
            if (size > 0) {
                System.out.println("从数组中删除数据" + li.get(size - 1));
                li.remove(size - 1);
                size--;
                this.notifyAll();
                // try {
                //     Thread.sleep(100);
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }
            } else {
                try {
                    System.out.println("数组已空");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        final Question1 q = new Question1();
        Thread[] addT = new Thread[30];
        Thread[] revT = new Thread[30];
        for (int i = 0; i < 30; i++) {
            addT[i] = new Thread() {
                @Override
                public void run() {
                    q.add();
                }
            };
            revT[i] = new Thread() {
                @Override
                public void run() {
                    q.remove();
                }
            };
        }
        for (int i = 0; i < 30; i++) {
            addT[i].start();
            revT[i].start();
            // try {
            //     addT[i].join();
            //     revT[i].join();
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
        }
    }
}
