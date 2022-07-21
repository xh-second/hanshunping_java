package com.formssi.proxy;

import java.lang.reflect.*;

/**
 * @author Yang XinHua
 * @date 2022/5/1
 */
public class JDKDynamic {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //得到代理类的Class对象
        Class<?> proxyClass = Proxy.getProxyClass(UserManager.class.getClassLoader(), UserManager.class);
        System.out.println("-----------");
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        UserManager userManagerProxy = (UserManager) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                UserManager userManager = new UserManagerImpl();
                System.out.println("5645");
                return method.invoke(userManager,args);
            }
        });
        userManagerProxy.addUser("223","23");
    }
}
