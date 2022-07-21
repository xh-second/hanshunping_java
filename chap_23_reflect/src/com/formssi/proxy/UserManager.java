package com.formssi.proxy;

/**
 * @author Yang XinHua
 * @date 2022/5/1
 */
/**
 * 目标接口类
 */
public interface UserManager {
    public void addUser(String id, String password);
    public void delUser(String id);
}

