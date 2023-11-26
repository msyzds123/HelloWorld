package com.iweb.util;

/**
 * @author Min
 * @date 2023/11/13 22:31
 */
public class PrintUtil {
    public static void log(String message){
        if(message.isEmpty()){
            System.out.println();
        }else {
            for (int i = 0; i < message.length(); i++) {
                System.out.print(message.charAt(i));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
