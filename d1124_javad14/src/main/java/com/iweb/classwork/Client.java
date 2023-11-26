package com.iweb.classwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Min
 * @date 2023/11/24 16:15
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("127.0.0.1",8888);
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        DataOutputStream dos = new DataOutputStream(os);
        DataInputStream dis = new DataInputStream(is);
        Scanner sc = new Scanner(System.in);
        while (true){
            dos.writeUTF(sc.nextLine());
            System.out.println("收到服务器端信息："+dis.readUTF());
        }
    }
}
