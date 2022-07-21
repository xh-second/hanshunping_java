package com.formssi.proxy;

/**
 * @author Yang XinHua
 * @date 2022/5/1
 */
public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String id, String password) {
        System.out.println("调用了add User 方法");
    }

    @Override
    public void delUser(String id) {
        System.out.println("调用了delUser()方法");
    }
}
