package com.iweb.view;

import com.iweb.controller.Controller;
import com.iweb.entity.User;
import com.iweb.util.PrintUtil;

import java.util.Scanner;

/**
 * @author Min
 * @date 2023/11/13 22:30
 */
public class View {
    private static Scanner sc = new Scanner(System.in);

    public static void mainView(){
        System.out.println("欢迎来到用户登陆系统");
        PrintUtil.log("-------------------");
        PrintUtil.log("请输入您要操作的业务");
        PrintUtil.log("1.注册，2.登录");
        String inputKey = sc.nextLine();
        // TODO:2023/11/10
        Controller.mainController(inputKey);
    }
    public static User loginView(){
        PrintUtil.log("请输入你的用户名");
        String inputUserName = sc.nextLine();
        PrintUtil.log("请输入您的密码");
        String inoutPasswod = sc.nextLine();
        //对输入的数据进行封装
        User inputUser = new User();
        inputUser.setUserName(inputUserName);
        inputUser.setUserPassword(inoutPasswod);
        return inputUser;
    }
    public static User registerView(){
        PrintUtil.log("请输入你的用户名");
        String inputUserName = sc.nextLine();
        PrintUtil.log("请输入您的密码");
        String inoutPasswod = sc.nextLine();
        User inputUser = new User();
        inputUser.setUserName(inputUserName);
        inputUser.setUserPassword(inoutPasswod);
        return inputUser;

    }
    public static void userInfoView(){
        PrintUtil.log("请输入要操作的功能序号");
        PrintUtil.log("1.查看用户信息，2.查看用户信息");

    }

    public static void main(String[] args) {

    }
}
