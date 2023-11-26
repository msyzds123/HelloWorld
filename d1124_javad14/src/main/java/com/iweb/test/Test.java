package com.iweb.test;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket编程
 * ServerSocker代表服务器端
 * Socket代表客户端
 * ip地址和端口
 * @author Min
 * @date 2023/11/24 15:32
 */
public class Test {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8888);
        //监听端口，并且接受客户端发送过来的socket对象
        System.out.println("正在监听端口8888");
        Socket s = ss.accept();
        System.out.println("有客户端接入");
        //获取客户端的输入流
        InputStream is = s.getInputStream();
        //为了统一输入输出的字符集编码，封装数据流
        DataInputStream dis = new DataInputStream(is);
        //使用readUTF进行字符串读取
        System.out.println(dis.readUTF());
    }
}
