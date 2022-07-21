package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Yang XinHua
 * @date 2022/7/18
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server 哈哈哈".getBytes());
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLength;
        while ((readLength = inputStream.read(buf)) != -1) {
            System.out.println("收到来自server的信息: " + new String(buf,0,readLength));
        }
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
