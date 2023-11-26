package com.iweb.client;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author Min
 * @date 2023/11/24 18:57
 */
public class ReceiveThread extends Thread {
    Socket socket;

    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        DataInputStream dis = null;
        try {
            while (true) {
                if (socket.isConnected()) {
                    is = socket.getInputStream();
                    dis = new DataInputStream(is);
                    System.out.println(dis.readUTF());
                } else {
                    break;
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                socket.close();
                is.close();
                dis.close();
                System.out.println("聊天结束");
            } catch (Exception e) {

            }
        }
    }
}
