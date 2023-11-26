package com.iweb.util;

import java.util.Random;

/**
 * @author Min
 * @date 2023/11/13 22:31
 */
public class StringUtil {
    private static final String strPool =
            "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    private static final Random r = new Random();
    public static String getCaptcha(){
        StringBuilder sb = new StringBuilder();
        int count = r.nextInt(3)+4;
        for(int i = 0;i<count;i++){
            sb.append(strPool.charAt(r.nextInt(strPool.length())));
        }
        return sb.toString();
    }
}
