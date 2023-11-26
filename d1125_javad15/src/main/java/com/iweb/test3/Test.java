package com.iweb.test3;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射核心体现在Spring
 * IOC控制反转
 * DI 依赖注入
 * @author Min
 * @date 2023/11/25 10:58
 */
public class Test {
    public static void main(String[] args) throws Exception{
        //从配置文件中提取所需要的信息
        File springConfigFile = new File("D:\\idea_workspace\\day1115_javad11\\d1125_javad15\\src\\main\\java\\com\\iweb\\test3\\spring.properties");
        //使用java提供的Properties类
        Properties springConfig = new Properties();
        springConfig.load(new FileInputStream(springConfigFile));
        //工具类会自动提取所有的配置文件信息并且封装成Map
        //只需要通过get方式获取配置文件信息即可
        String className = (String) springConfig.get("className");
        String methodName = (String) springConfig.get("methodName");
        Class uClass = Class.forName(className);
        Method m = uClass.getMethod(methodName);
        Constructor<UserService> c= uClass.getConstructor();
        m.invoke(c.newInstance());
    }
}
