package com.iweb.classwork;

import lombok.Data;

import java.util.Random;

/**
 * @author Min
 * @date 2023/11/20 23:02
 */
@Data
public class Hercules extends Thread {
    private int count;

    public void run() {
        Random r = new Random();
        while (true) {
            count = r.nextInt(100)+1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
