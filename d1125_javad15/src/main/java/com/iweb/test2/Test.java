package com.iweb.test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Method 方法的反射对象
 * @author Min
 * @date 2023/11/25 10:43
 */
public class Test {
    public static void main(String[] args) throws Exception{
        //借助反射获取相关的set方法的反射对象并最终调用sell方法
        Class pClass = Class.forName("com.iweb.test2.Product");
        Constructor<Product> cp = pClass.getConstructor();
        Product p = cp.newInstance();
        Method settIdMethod = pClass.getMethod("setId",Integer.class);
        Method setNameMethod = pClass.getMethod("setName", String.class);
        Method setPriceMethod = pClass.getMethod("setPrice", Float.class);
        settIdMethod.invoke(p,1);
        setNameMethod.invoke(p,"眉笔");
        setPriceMethod.invoke(p,79.0f);
        Method sellMethod = pClass.getMethod("sell");
        sellMethod.invoke(p);
    }
}
