package com.iweb.classwork;

/**
 * @author Min
 * @date 2023/11/21 10:49
 */
public class Question2 {
    int i = 0;

    public synchronized void printA() {
        if (i == 0) {
            System.out.println("A");
            i++;
            this.notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void printB() {
        if (i == 1) {
            System.out.println("B");
            i--;
            this.notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Question2 q = new Question2();
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    q.printA();
                    q.printB();
                }
            }
        };
        t.start();


    }
}
