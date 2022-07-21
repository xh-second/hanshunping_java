package com.formssi.proxy;

/**
 * @author Yang XinHua
 * @date 2022/5/1
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        UserManagerImpl userManager = new UserManagerImpl();
        StaticProxyUserManager staticProxyUserManager = new StaticProxyUserManager(userManager);
        staticProxyUserManager.addUser("sewe","sadfa");
    }
}
