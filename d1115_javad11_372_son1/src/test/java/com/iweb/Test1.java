package com.iweb;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 批量测试
 * @author Min
 * @date 2023/11/15 20:38
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {JDBCtest.class , JDBCtest1.class})
public class Test1 {
}
