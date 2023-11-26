package com.iweb.classwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

/**
 * @author Min
 * @date 2023/11/24 16:15
 */
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("正在监听8888端口");
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        DataInputStream dis = new DataInputStream(is);
        while (true){
            String key = dis.readUTF();
            List<TBDao> ls  = TBDao.listByLike(key);
            Iterator<TBDao> it = ls.iterator();
            dos.writeUTF(it.next().response);
        }
    }
}
