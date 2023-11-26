package com.iweb.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 当多个线程都需要连接数据库执行sql语句的时候
 * 每个线程会创建一个链接，并且在使用之后，关闭连接
 * 创建连接和关闭连接的过程是比较消耗性能的，多线程并发的场景下就会很卡顿
 * 并且，同一个数据库同时支持的连接总数是有上限的
 * 如果多线程并发量大，数据库链接的总数就会被消耗光
 * 后续线程发起的数据库连接就会失效
 * 连接池原理：
 * 连接池在适应之前，就会创建好一定数量的连接
 * 如果有任何线程需要使用连接，则从连接池归借用
 * 而不是重新创建，使用完毕后，再将连接归还给连接池
 * 供自己下一次使用或者是其他线程使用
 * 在并发场景下，如果连接池的连接被借用完了
 * 其他需要使用连接的线程就会等待，直到有连接被归还
 * 整个过程中，所有的连接都不会被关闭，而是不断的循环使用，从而节约了启动和关闭连接的使用
 * 后续框架开发的时候使用第三方开发的数据库连接池，hikiri连接池，c3p0（不推荐用），druid（德鲁伊）
 *
 * @author Min
 * @date 2023/11/23 16:25
 */
// 手动实现一个连接池
// 实例化一个有三条连接的数据库连接池，然后创建100个线程
// 每一个线程都会从连接池中借用连接并归还
// 每个线程执行一个耗时1s的sql语句
public class Test {
    static class WorkingThread extends Thread {
        private ConnectionPool cp;

        public WorkingThread(String name, ConnectionPool cp) {
            super((name));
            this.cp = cp;
        }

        public void run() {
            Connection c = cp.getConnection();
            System.out.println(this.getName() + ":\t接到了sql语句");
            try (PreparedStatement ps = c.prepareStatement("select * from student")) {
                Thread.sleep(1000);
                ps.executeQuery();
            }catch (Exception e){
                e.printStackTrace();
            }
            cp.returnConnection(c);
        }
    }

    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPool(3);
        for (int i = 0; i < 100; i++) {
            new WorkingThread("工作线程"+i,cp).start();
        }
    }
}
