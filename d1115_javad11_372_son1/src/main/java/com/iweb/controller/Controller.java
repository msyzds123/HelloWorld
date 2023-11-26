package com.iweb.controller;

import com.iweb.entity.User;
import com.iweb.service.Service;
import com.iweb.util.PrintUtil;
import com.iweb.view.View;

/**
 * @author Min
 * @date 2023/11/13 22:29
 */
public class Controller {
    public static void mainController(String key){
        switch (key){
            case "2" :
                // TODO:2023/11/10 调用登陆相关业务
                User inputUser = View.loginView();
                boolean login = Service.login(inputUser);
                //根据登录逻辑跳转下一步视图
                if(login){
                    //跳转到成功登录视图
                    System.out.println("登陆成功");
                    View.userInfoView();
                }else {
                    PrintUtil.log("用户名或密码有误，请重新输入");
                    View.mainView();
                }
                break;
            case "1":
                // TODO:2023/11/10 调用注册相关业务
                User inputSignUser = View.registerView();
                boolean register = Service.register(inputSignUser);
                if(register){
                    System.out.println("注册成功");
                    View.userInfoView();
                }else {
                    PrintUtil.log("用户名重复，请重新输入");
                    View.mainView();
                }
                break;

        }
    }


}
