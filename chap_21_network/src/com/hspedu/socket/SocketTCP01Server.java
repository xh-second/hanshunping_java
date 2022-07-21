package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Yang XinHua
 * @date 2022/7/18
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //1,在本机9999端口监听,等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket.getClass());
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLength = 0;
        while ((readLength = inputStream.read(buf)) != -1){
            System.out.println(new String(buf,0,readLength));
        }
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
