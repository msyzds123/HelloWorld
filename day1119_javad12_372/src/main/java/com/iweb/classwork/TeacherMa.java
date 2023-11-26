package com.iweb.classwork;

import lombok.Data;

/**
 * @author Min
 * @date 2023/11/20 23:00
 */
@Data
public class TeacherMa extends Thread {
    private Hercules marble;

    public void cd(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean test() {
        if (marble.getCount() <= 10) {
            System.out.println("不讲伍德");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("接");
            cd(1000);
            if (test()) {
                break;
            }
            System.out.println("化");
            cd(1000);
            if (test()) {
                break;
            }
            System.out.println("发");
            cd(1000);
            if (test()) {
                break;
            }
            System.out.println("闪电");
            cd(2000);
        }
    }
}
