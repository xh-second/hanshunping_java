package com.hspedu.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Yang XinHua
 * @date 2022/7/18
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回= " + socket.getClass());
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello Server".getBytes());
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
