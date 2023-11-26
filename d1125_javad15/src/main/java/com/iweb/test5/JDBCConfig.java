package com.iweb.test5;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * @author Min
 * @date 2023/11/25 14:03
 */
@Target({METHOD,TYPE})
@Retention(RUNTIME)
@Inherited
@Documented
//@Repeatable  1.8新增的元注解，表示同一个位置，当前自定义注解可以出现多次
public @interface JDBCConfig {
    String url();
    String username();
    String password();
}
