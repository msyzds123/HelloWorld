package com.iweb.homework;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Min
 * @date 2023/11/21 15:37
 */
public class Question2 {
    long maxFile ;
    long minFile ;
    String maxFileName;
    String minFileName;

    public void lookFile(File f) {
        if (f.isDirectory()) {
            final File[] fs = f.listFiles();
            Thread t = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < fs.length; i++) {
                        lookFile(fs[i]);
                    }
                }
            };
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            if (maxFile<f.length()) {
                maxFile = f.length();
                maxFileName = f.getName();
            }
            if (f.length() < minFile) {
                minFile = f.length();
                minFileName = f.getName();
            }
        }
    }

    public static void main(String[] args) {
        // System.out.println("输入要查找的文件");
        // Scanner sc = new Scanner(System.in);
        // String fileName = sc.nextLine();
        File f = new File("C:\\Users\\86189\\Desktop\\java");
        Question2 q = new Question2();
        if(f.isDirectory()){
            File[] fs = f.listFiles();
            q.minFile = fs[0].length();
            q.minFileName = fs[0].getName();
            q.maxFile = fs[1].length();
            q.maxFileName = fs[1].getName();
        }
        q.lookFile(f);
        System.out.printf("最大文件%s，大小为%d", q.maxFileName, q.maxFile);
        System.out.printf("最小文件%s，大小为%d", q.minFileName, q.minFile);
    }
}
