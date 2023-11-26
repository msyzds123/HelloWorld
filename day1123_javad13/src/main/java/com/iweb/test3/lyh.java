package com.iweb.test3;

/**
 * @author Min
 * @date 2023/11/23 20:14
 */
public class lyh extends Thread{
    private volatile boolean flag = false;
    public boolean isFlag(){
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            flag = true;
            System.out.println("flag:"+flag);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
