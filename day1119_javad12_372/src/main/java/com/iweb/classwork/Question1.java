package com.iweb.classwork;

/**
 * @author Min
 * @date 2023/11/20 22:08
 */
public class Question1 {
    public static void main(String[] args) {
        Hercules msy = new Hercules();
        TeacherMa zyx = new TeacherMa();
        zyx.setMarble(msy);
        msy.setDaemon(true);
        zyx.start();
        msy.start();
    }
}
