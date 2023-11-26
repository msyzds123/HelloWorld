package com.iweb.test;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Min
 * @date 2023/11/24 15:38
 */
public class TestClient {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("127.0.0.1",8888);
        System.out.println(s);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("主演男是常州人");
    }
}
