package com.formssi.proxy;

/**
 * @author Yang XinHua
 * @date 2022/5/1
 */
public class StaticProxyUserManager implements UserManager {

    private UserManagerImpl userManager;

    public StaticProxyUserManager() {
    }

    public StaticProxyUserManager(UserManagerImpl userManager) {
        this.userManager = userManager;
    }

    @Override
    public void addUser(String id, String password) {
        System.out.println("开始静态代理");
        userManager.addUser(id,password);
    }

    @Override
    public void delUser(String id) {

    }
}
