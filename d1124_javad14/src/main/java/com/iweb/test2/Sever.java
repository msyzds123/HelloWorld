package com.iweb.test2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Min
 * @date 2023/11/24 15:52
 */
public class Sever {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("正在监听8888端口");
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        DataInputStream dis = new DataInputStream(is);
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("收到客户端消息："+dis.readUTF());
            dos.writeUTF(sc.nextLine());
        }
    }
}
