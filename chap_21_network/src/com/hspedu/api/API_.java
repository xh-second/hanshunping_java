package com.hspedu.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Yang XinHua
 * @date 2022/7/18
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());
        InetAddress byName = InetAddress.getByName("baidu.com");
        System.out.println(byName);
    }
}
