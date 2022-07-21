package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Yang XinHua
 * @date 2022/7/18
 */
@SuppressWarnings("all")
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLength;
        while ((readLength = inputStream.read(buf)) != -1){
            System.out.println("收到来自客户端的信息: " + new String(buf,0,readLength));
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello Client".getBytes());
        //设置结束标志
        socket.shutdownOutput();
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
