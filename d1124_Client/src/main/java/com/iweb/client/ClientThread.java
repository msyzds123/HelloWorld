package com.iweb.client;

import java.net.Socket;
import java.util.Scanner;

/**
 * @author Min
 * @date 2023/11/24 19:01
 */
public class ClientThread {
    public static void main(String[] args) {
        try{
            System.out.println("输入ip");
            String ip = new Scanner(System.in).nextLine();
            Socket socket = new Socket(ip,8888);
            //启动发送消息线程和接收消息线程
            new SendThread(socket).start();
            new ReceiveThread(socket).start();
        }catch (Exception e){

        }
    }
}
